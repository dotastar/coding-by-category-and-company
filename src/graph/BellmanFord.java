/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BellmanFord.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a graph and a source vertex src in graph, find shortest paths from src to all vertices in the given graph.
 *                    Dijkstra doesn't work for Graphs with negative weight edges, Bellman-Ford works for such graphs.
 *                    Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. 
 *                    But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
 *                    Refer: http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
 *                    
 *                    NOTE: Bellman-Ford Algorithm can extend to Floyd-Warshall Algorithm
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.Arrays;

import util.EdgeGraph;

public class BellmanFord {
    public int[] bellmanFord(EdgeGraph graph, int src) {
        int[] dist = new int[graph.V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i <= graph.V - 1; i++) {
            for (int j = 0; j < graph.E; j++) {
                int u = graph.edges.get(j).src;
                int v = graph.edges.get(j).dec;
                int weight = graph.edges.get(j).weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        //last step: check for negative-weight cycles.
        for (int i = 0; i < graph.E; i++) {
            int u = graph.edges.get(i).src;
            int v = graph.edges.get(i).dec;
            int weight = graph.edges.get(i).weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("graph contains negative weight cycle!");
            }
        }
        return dist;
    }
}
