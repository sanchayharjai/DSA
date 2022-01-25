import java.util.List;

public class TopologicalSort {
    /*
        a topological sort or topological ordering of a directed graph
        is a linear ordering of its vertices such that for every directed
        edge uv from vertex u to vertex v, u comes before v in the ordering
        A topological ordering is possible if and only if the graph has no
        directed cycles. Can be Achieved with dfs of kahn's algorithm.

        Time Complexity: O(V + E)
     */

    private int dfs(int i, int at, int[] order, List<Integer> graph[], boolean visited[]){
        if(visited[at]) return i;
        visited[at] = true;
        for(int neighbour : graph[at]) i = dfs(i,neighbour,order,graph,visited);
        order[i] = at;
        return i - 1;
    }
    public int[] topSortDFS(List<Integer> graph[]){
        int order[] = new int[graph.length];
        int i = graph.length - 1;
        boolean[] visited = new boolean[graph.length];
        for(int n = 0; n < graph.length; n++) if(!visited[n]) i = dfs(i,n,order,graph,visited);
        return order;
    }

}
