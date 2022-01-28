package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    public static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }
    int id = 0;
    public List<Integer> Bridges(List<Edge> graph[]){
        id = 0;
        int[] ids = new int[graph.length];
        int[] lo = new int[graph.length];
        boolean visited[] = new boolean[graph.length];
        List<Integer> bridges = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) if(!visited[i]) dfs(i,-1,graph,ids,lo,visited,bridges);
        return bridges;
    }
    public void dfs(int at, int parent, List<Edge> graph[], int[] ids, int lo[], boolean[] visited, List<Integer> bridges){
        visited[at] = true;
        id++;
        ids[at] = id;
        lo[at] = id;
        for(Edge e : graph[at]){
            if(e.to == parent) continue;
            if(visited[e.to]) lo[at] = Math.min(ids[e.to],lo[at]);
            else{
                dfs(e.to,at,graph,ids,lo,visited,bridges);
                lo[at] = Math.min(lo[at],lo[e.to]);
                if(ids[at] < lo[e.to]){
                    bridges.add(at);
                    bridges.add(e.to);
                }
            }

        }
    }
}
