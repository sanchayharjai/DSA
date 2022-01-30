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
    /*
    a bridge, isthmus, cut-edge, or cut arc is an edge of a graph whose deletion increases the
    graph's number of connected components. Equivalently, an edge is a bridge if and only if
     it is not contained in any cycle.
    First thought
    An edge is a bridge, if and only if it is not in a cycle.
    So, if we know how to find cycles, and discard all edges in the cycles, then
     the remaining connections are a complete collection of bridges.
    How to find eges in cycles, and remove them -
    We use DFS algorithm to find cycles and decide whether or not an edge is in a cycle.
    Define rank of a node: The depth of a node during a DFS. The starting node has a rank 0.
    Only the nodes on the current DFS path have non-special ranks. In other words, only the
    nodes that we've started visiting, but haven't finished visiting, have ranks. So 0 <= rank < n.
    How can "rank" help us with removing cycles? Imagine you have a current path of length k during
    a DFS. The nodes on the path has increasing ranks from 0 to kand incrementing by 1. Surprisingly,
    your next visit finds a node that has a rank of p where 0 <= p < k. Why does it happen? Aha!
    You found a node that is on the current search path! That means, congratulations, you found a cycle!

    But only the current level of search knows it finds a cycle. How does the upper level of search
    knows, if you backtrack? Let's make use of the return value of DFS: dfs function returns the
    minimum rank it finds. During a step of search from node u to its neighbor v, if dfs(v) returns
    something smaller than or equal to rank(u), then u knows its neighbor v helped it to find a cycle
     back to u or u's ancestor. So u knows it should discard the edge (u, v) which is in a cycle.

    After doing dfs on all nodes, all edges in cycles are discarded. So the remaining edges are bridges.
     */
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
    private void dfs(int at, int parent, List<Edge> graph[], int[] ids, int lo[], boolean[] visited, List<Integer> bridges){
        visited[at] = true;
        id++;
        ids[at] = id;
        lo[at] = id;
        for(Edge e : graph[at]){
            // If it is parent we simply disregard as we want a temporary directed path
            // in the graph
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
