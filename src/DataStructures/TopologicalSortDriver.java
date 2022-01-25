package DataStructures;

import java.util.ArrayList;
import java.util.List;
public class TopologicalSortDriver {

    public static void main(String[] args) {
//          TopSort
        TopologicalSort topsort = new TopologicalSort();
        List<TopologicalSort.Edge> graph[] = new List[7];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        graph[0].add(new TopologicalSort.Edge(0, 1, 3));
        graph[0].add(new TopologicalSort.Edge(0, 2, 2));
        graph[0].add(new TopologicalSort.Edge(0, 5, 3));
        graph[1].add(new TopologicalSort.Edge(1, 3, 1));
        graph[1].add(new TopologicalSort.Edge(1, 2, 6));
        graph[2].add(new TopologicalSort.Edge(2, 3, 1));
        graph[2].add(new TopologicalSort.Edge(2, 4, 10));
        graph[3].add(new TopologicalSort.Edge(3, 4, 5));
        graph[5].add(new TopologicalSort.Edge(5, 4, 7));
        int[] order = topsort.topSortDFS(graph);
        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        for(int i : order) System.out.print(i+" ");
        System.out.println();
        int[] path = topsort.dagShortestPath(graph,0);
        System.out.println(path[4]);

    }
}