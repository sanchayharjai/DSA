package Algorithms;

import java.util.List;

public class ArticulationPoints {
    public static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }
    /*
    Basically same as finding bridges, every bridge constitutes 2 articulation points however
    the difference is of starting node, starting node is always considered as articulation
    point according to the algorithm, it might be wrong, starting node is articulation
    point only if the outgoing edge/paths during dfs were > 1.
     */
    int outEdges = 0;
    int id = 0;
    public boolean[] articulationPoints(List<Edge> graph[]){
        boolean[] visited = new boolean[graph.length];
        int[] ids = new int[graph.length];
        int[] lo = new int[graph.length];
        boolean[] isArt = new boolean[graph.length];
        outEdges = 0;
        id = 0;
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]) {
                dfs(i, i, -1, ids, lo, visited, graph, isArt);
                isArt[i] = outEdges > 1;
                outEdges = 0;
            }
        }
        return isArt;
    }
    private void dfs(int root, int cur, int parent, int[] ids, int[] lo, boolean[] visited, List<Edge> graph[], boolean[] isArt){
        if(parent == root) outEdges++;
        visited[cur] = true;
        ids[cur] = lo[cur] = ++id;
        for(Edge e : graph[cur]){
            if(e.to == parent) continue;
            if(visited[e.to]) lo[cur] = Math.min(ids[e.to],lo[cur]);
            else{
                dfs(root,e.to,cur,ids,lo,visited,graph,isArt);
                lo[cur] = Math.min(lo[cur],lo[e.to]);
                if(lo[e.to] >= ids[cur]) isArt[cur] = true;
            }
        }
    }
}
