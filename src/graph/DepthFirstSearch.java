/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DepthFirstSearch.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Depth First Traversal (or Search) for a undirected graph 
 *                    
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;

import util.GraphNode;

public class DepthFirstSearch {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

    public void addEdge(int v, int w) {
        if (graph.containsKey(v)) {
            graph.put(v, new GraphNode(v));
        }
        if (graph.containsKey(w)) {
            graph.put(w, new GraphNode(w));
        }
        graph.get(v).neighbors.add(graph.get(w));
        graph.get(w).neighbors.add(graph.get(v));
        visited.put(v, false);
        visited.put(w, false);
    }

    public void dfs(int v) {
        visited.put(v, true);
        for (GraphNode neighbor : graph.get(v).neighbors) {
            if (visited.get(neighbor.label) == false) {
                dfs(neighbor.label);
            }
        }
    }

    public void dfs() {
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false) {
                dfs(key);
            }
        }
    }
}
