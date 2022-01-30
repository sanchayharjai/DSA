package Algorithms;
import Algorithms.ArticulationPoints.Edge;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointsDriver {
    public static void addEdge(List<Edge> graph[], int from, int to) {
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

        ArticulationPoints ap = new ArticulationPoints();
        boolean[] isArticulationPoint = ap.articulationPoints(graph);

        // Prints:
        // Node 2 is an articulation
        // Node 3 is an articulation
        // Node 5 is an articulation
        for (int i = 0; i < 9; i++)
            if (isArticulationPoint[i]) System.out.printf("Node %d is an articulation\n", i);

    }
}
