import java.util.ArrayList;
import java.util.List;

public class TopologicalSortDriver {

    public static void main(String[] args) {
        TopologicalSort topsort = new TopologicalSort();
        List<Integer> graph[] = new List[7];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        graph[0].add(1);
        graph[0].add(2);
        graph[0].add(5);
        graph[1].add(3);
        graph[1].add(2);
        graph[2].add(3);
        graph[2].add(4);
        graph[3].add(4);
        graph[5].add(4);
        int[] order = topsort.topSortDFS(graph);
        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        for(int i : order) System.out.print(i+" ");
    }
}
