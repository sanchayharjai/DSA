package Algorithms;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class TopologicalSort {
    /*
        a topological sort or topological ordering of a directed graph
        is a linear ordering of its vertices such that for every directed
        edge uv from vertex u to vertex v, u comes before v in the ordering
        A topological ordering is possible if and only if the graph has no
        directed cycles. Can be Achieved with dfs of kahn's algorithm.

        Time Complexity: O(V + E)
     */
    public static class Edge {
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    private int dfs(int i, int at, int[] order, List<Edge> graph[], boolean visited[]){
        if(visited[at]) return i;
        visited[at] = true;
        for(Edge neighbour : graph[at]) i = dfs(i,neighbour.to,order,graph,visited);
        order[i] = at;
        return i - 1;
    }
    public int[] topSortDFS(List<Edge> graph[]){
        int order[] = new int[graph.length];
        int i = graph.length - 1;
        boolean[] visited = new boolean[graph.length];
        for(int n = 0; n < graph.length; n++) if(!visited[n]) i = dfs(i,n,order,graph,visited);
        return order;
    }
    public int[] dagShortestPath(List<Edge> graph[], int start){
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        int topsort[] = topSortDFS(graph);
        for(int i = 0; i < topsort.length; i++){
            if(dist[i] == Integer.MAX_VALUE) continue;
            for(Edge e : graph[i]) dist[e.to] = Math.min(dist[e.to],dist[i] + e.weight);
        }
        return dist;
    }
    public int[] kahns(List<Edge> graph[]){
        int inDegree[] = new int[graph.length];
        for( List<Edge> edges : graph){
            for(Edge e : edges) inDegree[e.to]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < inDegree.length; i++) if(inDegree[i] == 0) q.addLast(i);
        int index = 0;
        int[] ordering = new int[graph.length];
        while(!q.isEmpty()){
            int cur = q.pollFirst();
            ordering[index++] = cur;
            for(Edge e : graph[cur]) if(--inDegree[e.to] == 0) q.addLast(e.to);
        }
        if(index != graph.length) throw new IllegalArgumentException("Not a DAG, No topological ordering possible");
        return ordering;
    }

}
