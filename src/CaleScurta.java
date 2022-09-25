import java.io.FileWriter;
import java.io.IOException;

/** Represents the class where the minimum distances from a node to the other
 * ones will be calculated using dijkstra algorithm.
 *
 */
public class CaleScurta {

    /** Goes recursivly from the destination Node to the root Node (the first node)
     * and writes the path to the output file.
     * @param parent represents an array where the index is the node's index
     *               and the value represents the parent's index (parent = the
     *               previous node).
     * @param root is a Node which represents the first Node (the root node).
     * @param out the output file, where the path will be written.
     * @throws IOException if the file is not found, throws an exception.
     */
    void cale(int[] parent, int root, FileWriter out) throws IOException{
        if(parent[root] == -1) {
            out.write("P" + root + " ");
            return;
        }
        cale(parent,parent[root],out);
        out.write("P" + root + " ");
    }

    /** Returns the index of the node with the lowest cost.
     * @param nr_nod an int, representing the number of nodes.
     * @param noduri an array, where all nodes are stored.
     * @param dist an int array, which represents the minimum distances
     *             to all the nodes.
     * @return returns an integer, which is the index of the lowest cost node.
     */
    int distMinima(int nr_nod, Nod[] noduri, int[] dist) {
        int min = 1000, ind_dest = -1;
        for(int i = 0; i < nr_nod; i++) {
            if(dist[i] < min && !noduri[i].getVisited()) {
                min = dist[i];
                ind_dest = i;
            }
        }
        return ind_dest;
}

    /** Applies the dijkstra algorithm using an adjancency matrix of an array of Nodes.
     * @param node_arr represents the nodes array.
     * @param rad is a Node, the main node from which the distances are calculated (the root Node).
     * @param nr_nod an integer representing the number of nodes.
     * @param dest is a Node, representing the destination node.
     * @param vh is an Autovehicul with a specific cost and weight; it can be Motocicleta,Bicicleta,
     *           Camion,Autoturism.
     * @param out represents the output file, where the results will be written.
     * @throws IOException an exception if the file is not found.
     */
    void alg_dijkstra(Nod[] node_arr, Nod rad, int nr_nod, Nod dest, Autovehicul vh, FileWriter out) throws IOException {

        //array with the costs for every node form the root node
        int[] dist = new int[nr_nod];
        //array with the parent of every node after the distances were calculated;used to show the path
        int[] parent = new int[nr_nod];
        String name_root = rad.getName();
        String name_dest = dest.getName();

        //cost array initialization
        for(int i = 0; i < nr_nod; i++) {
            dist[i] = 1000;
        }
        int index_nod = rad.getIndex();
        dist[index_nod] = 0;
        parent[index_nod] = -1;
        //u - index of the node with the lowest cost
        int u;
        for(int i = 0; i < nr_nod - 1; i++) {
            u = distMinima(nr_nod, node_arr, dist);
            //verifies if the node has edges
            if(u >= 0) {
                //sets the node as visited
                node_arr[u].setVisited(true);
                for (int v = 0; v < node_arr[u].getVecini(); v++) {
                    //verifies the weight and cost conditions for every other node
                    Strada street = node_arr[u].getStrada(v);
                    if (street.getLimitaGabarit() >= vh.gabarit) {
                        int index_dest = street.getIndexDestinatie();
                        int cost_total = street.getCost() * vh.cost;
                        if (street.getAmb() != null)
                            for (int k = 0; k < street.getNr_ambutiaje(); k++)
                                cost_total += street.getAmbuteiaj(k).getCost();
                        if (!node_arr[index_dest].getVisited() && dist[u] != 1000 && dist[u] + cost_total < dist[index_dest]) {
                            parent[index_dest] = u;
                            dist[index_dest] = dist[u] + cost_total;
                        }
                    }
                }
            }
        }
        //index of the destination node
        int index_dest = dest.getIndex();
        //verifies if there isn't a path to the destination node
        if(dist[index_dest] == 1000){
            out.write(name_root + " " + name_dest + " null");
            out.write(System.lineSeparator());
            return;
        }
        //writes the path to the nodes
        cale(parent, index_dest,out);
        out.write(String.valueOf(dist[index_dest]));
        out.write(System.lineSeparator());
    }
}
