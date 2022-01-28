package Algorithms;
import Algorithms.BellmanFord.Edge;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordDriver {
    public static void addEdge(List<Edge>[] graph, int from, int to, double cost) {
        graph[from].add(new Edge(from, to, cost));
    }

    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord();
        int E = 10, V = 9, start = 0;
        List<Edge>[] graph = new List[V];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 2, 4, 1);
        addEdge(graph, 4, 3, -3);
        addEdge(graph, 3, 2, 1);
        addEdge(graph, 1, 5, 4);
        addEdge(graph, 1, 6, 4);
        addEdge(graph, 5, 6, 5);
        addEdge(graph, 6, 7, 4);
        addEdge(graph, 5, 7, 3);
        double[] d = bf.BellmanFord(graph, start);

        for (int i = 0; i < V; i++)
            System.out.printf("The cost to get from node %d to %d is %.2f\n", start, i, d[i]);

        // Output:
        // The cost to get from node 0 to 0 is 0.00
        // The cost to get from node 0 to 1 is 1.00
        // The cost to get from node 0 to 2 is -Infinity
        // The cost to get from node 0 to 3 is -Infinity
        // The cost to get from node 0 to 4 is -Infinity
        // The cost to get from node 0 to 5 is 5.00
        // The cost to get from node 0 to 6 is 5.00
        // The cost to get from node 0 to 7 is 8.00
        // The cost to get from node 0 to 8 is Infinity
    }
}
