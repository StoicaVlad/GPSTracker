.PHONY: all build run

all: build run

build: Main

Main:
	@javac -g -sourcepath src  -d . src/*.java

run:
	@java Main
