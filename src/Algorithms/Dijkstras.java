package Algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {
    public static class Edge {
        double cost;
        int from, to;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    /*
    Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a directed edge weighted graph,
    which may represent, for example, road networks
    Time complexity - O((V + E)log V)
     */

    public static class Node {
        int id;
        double value;

        public Node(int id, double value) {
            this.id = id;
            this.value = value;
        }
    }
    public double[] dijkstra(int start, List<Edge> graph[]){
        // Here the dist stores the dist from stating node to that node
        double dist[] = new double[graph.length];
        // Helps in coping with overflow
        Arrays.fill(dist,Double.POSITIVE_INFINITY);
        dist[start] = 0;
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Double.compare(a.value,b.value));
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.id]) continue;
            visited[cur.id] = true;
            for(Edge neighbour : graph[cur.id]){
                double newDist = dist[cur.id] + neighbour.cost;
                if(newDist >= dist[neighbour.to]) continue;
                dist[neighbour.to] = newDist;
                pq.add(new Node(neighbour.to, newDist));
            }
        }
        return dist;
    }
}
