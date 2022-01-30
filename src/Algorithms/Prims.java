package Algorithms;

import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    /*
      Prim's algorithm (also known as Jarník's algorithm) is a greedy algorithm
      that finds a minimum spanning tree for a weighted undirected graph. This
      means it finds a subset of the edges that forms a tree that includes every
      vertex, where the total weight of all the edges in the tree is minimized.
      The algorithm operates by building this tree one vertex at a time, from an
      arbitrary starting vertex, at each step adding the cheapest possible connection
      from the tree to another vertex.Prim’s algorithm assumes that all vertices are
      connected. But in a directed graph, every node is not reachable from every
      other node. So, Prim’s algorithm fails due to this reason.
      Time complexity - O((V+E)logV)
    */
    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    Edge[] edges;
    public void addEdge(List<Edge> graph[], boolean[] visited, int cur,PriorityQueue<Edge> pq){
        visited[cur] = true;
        for(Edge e : graph[cur]) if(!visited[e.to]) pq.add(e);
    }
    public int mstCost(List<Edge> graph[]){
        // To build path
        edges = new Edge[graph.length-1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        boolean visited[] = new boolean[graph.length];
        visited[0] = true;
        addEdge(graph,visited,0,pq);
        int cost = 0;
        int count = 0;
        while(!pq.isEmpty() && count < graph.length){
            // Greedily process the cheapest edge available
            Edge cur = pq.poll();
            // Stale edges
            if(visited[cur.to]) continue;
            cost+=cur.cost;
            edges[count++] = cur;
            addEdge(graph,visited,cur.to,pq);
        }
        return cost;
    }
    public Edge[] mstEdges(){
        return edges;

    }
}
