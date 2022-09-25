import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

/** Represents the Main class where the testing will be done.
 * @author Vlad Stoica
 */
public class Main {
    static int max_nod,max_streets;
    static Nod[] v_n;
    static Nod root, destination;
    static Autovehicul vehicle;

    /** The main method where a file will be written, creating an array
     * of nodes and adding streets for each node. After, the shortest path
     * bettwen 2 nodes recieved as input from the file will be calculated.
     * @param args arguments.
     */
    public static void main(String[] args) {
        try {
            File f = new File("map.in");
            FileWriter out = new FileWriter("map.out");
            Scanner read = new Scanner(f);

            max_streets = read.nextInt();
            max_nod = read.nextInt();
            v_n = new Nod[max_nod];
            for(int i = 0; i < max_nod; i++) {
                String name = "P" + i;
                v_n[i] = new Nod(name);
            }
            while (read.hasNext()) {
                String r_name = read.next();
                if(r_name.equals("accident") || r_name.equals("trafic") || r_name.equals("blocaj")) {
                    String nod_first = read.next();
                    String strada_bloc = nod_first + read.next();
                    int cost_accident = read.nextInt();
                    for(int i = 0; i < max_nod; i++) {
                        if(nod_first.equals(v_n[i].getName()))
                            for(int j = 0; j< v_n[i].getVecini(); j++) {
                                Strada verif = v_n[i].getStrada(j);
                                if (verif.getNume().equals(strada_bloc))
                                    verif.setAmb( verif.AdaugaAmbuteiaj(verif.getAmb(), r_name, cost_accident) );
                            }
                    }

                }
                else if (r_name.equals("drive")) {
                    String tip = read.next();
                    switch (tip) {
                        case "b" -> vehicle = new Bicicleta();
                        case "m" -> vehicle = new Motocicleta();
                        case "a" -> vehicle = new Autoturism();
                        case "c" -> vehicle = new Camion();
                    }
                    String first_node = read.next();
                    String final_node = read.next();
                    for(int i = 0; i < max_nod; i++) {
                        if (v_n[i].getName().equals(first_node))
                            root = v_n[i];
                        if (v_n[i].getName().equals(final_node))
                            destination = v_n[i];
                    }
                    CaleScurta c = new CaleScurta();
                    c.alg_dijkstra(v_n,root,max_nod,destination, vehicle, out );
                    for(int i = 0; i < max_nod; i++)
                        v_n[i].setVisited(false);

                }
                else {
                    for (int i = 0; i < max_nod; i++) {
                        if (v_n[i].getName().equals(r_name)) {
                            String dest = read.next();
                            int c = read.nextInt();
                            int g = read.nextInt();
                            Strada str = new Strada(v_n[i].getName() + dest, c, g, dest);
                            v_n[i].setVectorStrazi(v_n[i].AdaugaStrada(v_n[i].getVectorStrazi(),str));
                        }
                    }
                }
            }
            read.close();
            out.close();
        } catch (FileNotFoundException error) {
            System.out.println("File not found!");
            error.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
