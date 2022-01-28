package Algorithms;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static class Edge {
        double cost;
        int from, to;

        public Edge(int from, int to, double cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
    public double[] BellmanFord(List<Edge> graph[],int start){
        double[] dist = new double[graph.length];
        Arrays.fill(dist,Double.POSITIVE_INFINITY);
        dist[start] = 0;
        for(int i = 0; i < graph.length - 1; i++) {
            for (List<Edge> l : graph) {
                for (Edge e : l) {
                    dist[e.to] = Math.min(dist[e.to], dist[e.from] + e.cost);
                }
            }
        }
        for(int i = 0; i < graph.length - 1; i++) {
            for (List<Edge> l : graph) {
                for (Edge e : l) {
                    if (dist[e.from] + e.cost < dist[e.to])
                        dist[e.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        return dist;
    }
}
