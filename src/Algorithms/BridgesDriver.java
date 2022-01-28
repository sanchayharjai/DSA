package Algorithms;
import Algorithms.Bridges.Edge;

import java.util.ArrayList;
import java.util.List;

public class BridgesDriver {
    public static void addEdge(List<Edge>[] graph, int from, int to) {
        graph[from].add(new Edge(from,to));
        graph[to].add(new Edge(to,from));
    }
    public static void main(String[] args) {
        List<Edge> graph[] = new List[9];
        for(int i = 0; i < graph.length; i++)graph[i] = new ArrayList<>();
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 5);
        Bridges b = new Bridges();
        List<Integer> bridges = b.Bridges(graph);
        // Prints:
        // Bridge between nodes: 3 and 4
        // Bridge between nodes: 2 and 3
        // Bridge between nodes: 2 and 5
        for (int i = 0; i < bridges.size() / 2; i++) {
            int node1 = bridges.get(2 * i);
            int node2 = bridges.get(2 * i + 1);
            System.out.printf("Bridge between nodes: %d and %d\n", node1, node2);
        }
    }
}
