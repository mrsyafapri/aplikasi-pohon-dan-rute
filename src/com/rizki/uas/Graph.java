package com.rizki.uas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Muhammad Rizki Syafapri <12050110483>
 */
public class Graph {

    private final int vertices;
    private final int edges;
    private ArrayList<Integer>[] adjList;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        initAdjList();
    }

    private void initAdjList() {
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    public void printAllPaths(int source, int destination) {
        boolean[] isVisited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        printAllPathsUtil(source, destination, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer source, Integer destination, boolean[] isVisited, List<Integer> localPathList) {
        if (source.equals(destination)) {
            Iterator<Integer> it = localPathList.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (!it.hasNext()) {
                    System.out.println();
                } else {
                    System.out.print(" -> ");
                }
            }
            return;
        }
        isVisited[source] = true;
        for (Integer i : adjList[source]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, destination, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[source] = false;
    }

    public int countPaths(int source, int destination) {
        int pathCount = 0;
        pathCount = countPathsUtil(source, destination, pathCount);
        return pathCount;
    }

    private int countPathsUtil(int source, int destination, int pathCount) {
        if (source == destination) {
            pathCount++;
        } else {
            Iterator<Integer> i = adjList[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPathsUtil(n, destination, pathCount);
            }
        }
        return pathCount;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        System.out.println("Graph: ");
        for (int i = 0; i < vertices - 1; i++) {
            s.append(i).append(" -> ");
            for (int j : adjList[i]) {
                s.append(j).append(" | ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void getVertices() {
        System.out.println("Graph memiliki " + vertices + " vertex");
    }

    public void getEdges() {
        System.out.println("Graph memiliki " + edges + " edges(rute)");
    }
}
