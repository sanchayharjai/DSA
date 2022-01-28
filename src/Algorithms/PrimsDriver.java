package Algorithms;
import Algorithms.Prims.Edge;

import java.util.ArrayList;
import java.util.List;

public class PrimsDriver {
    public static void addUndirectedEdge(List<Edge> graph[],int from , int to, int cost){
        graph[from].add(new Edge(from,to,cost));
        graph[to].add(new Edge(to,from,cost));
    }

    public static void main(String[] args) {

        List<Edge> g[] = new List[10];
        for(int i = 0; i < 10; i++) g[i] = new ArrayList<>();
        addUndirectedEdge(g, 0, 1, 5);
        addUndirectedEdge(g, 1, 2, 4);
        addUndirectedEdge(g, 2, 9, 2);
        addUndirectedEdge(g, 0, 4, 1);
        addUndirectedEdge(g, 0, 3, 4);
        addUndirectedEdge(g, 1, 3, 2);
        addUndirectedEdge(g, 2, 7, 4);
        addUndirectedEdge(g, 2, 8, 1);
        addUndirectedEdge(g, 9, 8, 0);
        addUndirectedEdge(g, 4, 5, 1);
        addUndirectedEdge(g, 5, 6, 7);
        addUndirectedEdge(g, 6, 8, 4);
        addUndirectedEdge(g, 4, 3, 2);
        addUndirectedEdge(g, 5, 3, 5);
        addUndirectedEdge(g, 3, 6, 11);
        addUndirectedEdge(g, 6, 7, 1);
        addUndirectedEdge(g, 3, 7, 2);
        addUndirectedEdge(g, 7, 8, 6);
        Prims p = new Prims();
        System.out.println(p.mstCost(g));
        Edge edges[] = p.mstEdges();
        for(Edge e : edges) System.out.println(String.format("from: %d, to: %d, cost: %d", e.from, e.to, e.cost));

        // Output:
        // MST cost: 14
        // from: 0, to: 4, cost: 1
        // from: 4, to: 5, cost: 1
        // from: 4, to: 3, cost: 2
        // from: 3, to: 1, cost: 2
        // from: 3, to: 7, cost: 2
        // from: 7, to: 6, cost: 1
        // from: 6, to: 8, cost: 4
        // from: 8, to: 9, cost: 0
        // from: 8, to: 2, cost: 1
    }
}
