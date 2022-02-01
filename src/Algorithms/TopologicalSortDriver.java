package Algorithms;

import Algorithms.TopologicalSort.Edge;

import java.util.ArrayList;
import java.util.List;
public class TopologicalSortDriver {
    public static void addDirectedEdge(List<Edge> graph[],int from, int to){
        graph[from].add(new Edge(from,to,0));
    }

    public static void main(String[] args) {

    /*
//          TopSort
        TopologicalSort topsort = new TopologicalSort();
        List<Edge> graph[] = new List[7];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 2));
        graph[0].add(new Edge(0, 5, 3));
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 2, 6));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 10));
        graph[3].add(new Edge(3, 4, 5));
        graph[5].add(new Edge(5, 4, 7));
        int[] order = topsort.topSortDFS(graph);
        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        for(int i : order) System.out.print(i+" ");
        System.out.println();
        int[] path = topsort.dagShortestPath(graph,0);
        System.out.println(path[4]);
        */
        TopologicalSort topsort = new TopologicalSort();
        List<Edge> []g = new List[14];
        for(int i =0 ; i < g.length; i++) g[i] = new ArrayList<>();
        addDirectedEdge(g, 0, 2);
        addDirectedEdge(g, 0, 3);
        addDirectedEdge(g, 0, 6);
        addDirectedEdge(g, 1, 4);
        addDirectedEdge(g, 2, 6);
        addDirectedEdge(g, 3, 1);
        addDirectedEdge(g, 3, 4);
        addDirectedEdge(g, 4, 5);
        addDirectedEdge(g, 4, 8);
        addDirectedEdge(g, 6, 7);
        addDirectedEdge(g, 6, 11);
        addDirectedEdge(g, 7, 4);
        addDirectedEdge(g, 7, 12);
        addDirectedEdge(g, 9, 2);
        addDirectedEdge(g, 9, 10);
        addDirectedEdge(g, 10, 6);
        addDirectedEdge(g, 11, 12);
        addDirectedEdge(g, 12, 8);
        int[] ordering = topsort.kahns(g);

        // Prints: [0, 9, 13, 3, 2, 10, 1, 6, 7, 11, 4, 12, 5, 8]
        System.out.println(java.util.Arrays.toString(ordering));

    }
}