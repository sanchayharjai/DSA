package Algorithms;

import java.util.List;
import java.util.PriorityQueue;

public class Prims {
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
        edges = new Edge[graph.length-1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        boolean visited[] = new boolean[graph.length];
        visited[0] = true;
        addEdge(graph,visited,0,pq);
        int cost = 0;
        int count = 0;
        while(!pq.isEmpty() && count < graph.length){
            Edge cur = pq.poll();
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
