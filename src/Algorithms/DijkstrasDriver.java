package Algorithms;
import Algorithms.Dijkstras.Edge;

import java.util.ArrayList;
import java.util.List;

public class DijkstrasDriver {
    public static void main(String[] args) {
        List<Edge> graph[] = new ArrayList[5];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<Edge>();
        graph[0].add(new Edge(0,1,4));
        graph[0].add(new Edge(0,2,1));
        graph[2].add(new Edge(2,1,2));
        graph[2].add(new Edge(2,3,5));
        graph[1].add(new Edge(1,3,1));
        graph[3].add(new Edge(3,4,3));
        Dijkstras d = new Dijkstras();
        double[] arr = d.dijkstra(0,graph);
        for(double i : arr) System.out.println(i);
    }
}
