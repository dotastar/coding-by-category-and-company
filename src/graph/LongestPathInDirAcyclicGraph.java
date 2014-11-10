/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestPathInDirAcyclicGraph.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it, find the longest distances from s to all other vertices in the given graph.
 *                    We initialize distances to all vertices as minus infinite and distance to source as 0, then we find a topological sorting of the graph.
 *                    Once we have topological order (or linear representation), we one by one process all vertices in topological order.
 *                    For every vertex being processed, we update distances of its adjacent using distance of current vertex.
 *                    Refer: http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 *                    
 *                    NOTE this algorithm can be used to find shortest path in directed acyclic graph
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import util.GraphNode;

public class LongestPathInDirAcyclicGraph {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    Stack<Integer> topoAns = new Stack<Integer>();

    public void addEdge(int v, int w) {
        if (!graph.containsKey(v)) {
            graph.put(v, new GraphNode(v));
        }
        if (!graph.containsKey(w)) {
            graph.put(w, new GraphNode(w));
        }
        graph.get(v).adjs.add(graph.get(w));
        visited.put(v, false);
        visited.put(w, false);
    }

    public void topologicalSortUtil(int v, HashMap<Integer, Boolean> visited, Stack<Integer> ans) {
        visited.put(v, true);
        for (GraphNode adj : graph.get(v).adjs) {
            if (visited.get(adj.label) == false) {
                topologicalSortUtil(adj.label, visited, ans);
            }
        }
        ans.add(v);
    }

    public void longestPath(int s) {
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false) {
                topologicalSortUtil(key, visited, topoAns);
            }
        }
        HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
        for (Integer key : graph.keySet()) {
            dist.put(key, Integer.MIN_VALUE);
        }
        dist.put(s, 0);
        while (!topoAns.isEmpty()) {
            int u = topoAns.pop();
            if (dist.get(u) != Integer.MIN_VALUE) {
                for (GraphNode neighbor : graph.get(u).adjs) {
                    if (dist.get(neighbor.label) < dist.get(u) + graph.get(neighbor.label).weight) {
                        dist.put(neighbor.label, dist.get(u) + graph.get(neighbor.label).weight);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
