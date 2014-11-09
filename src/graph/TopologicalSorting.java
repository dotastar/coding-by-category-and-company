/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TopologicalSorting.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Topological sorting for Directed Acyclic Graph (DAG)
 *                    
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.Stack;

import util.GraphNode;

public class TopologicalSorting {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    Stack<Integer> ans = new Stack<Integer>();//NOTE, tricky!!!

    public void addEdge(int v, int w) {
        if (graph.containsKey(v)) {
            graph.put(v, new GraphNode(v));
        }
        if (graph.containsKey(w)) {
            graph.put(w, new GraphNode(w));
        }
        graph.get(v).neighbors.add(graph.get(w));
        visited.put(v, false);
        visited.put(w, false);
    }

    public void topologicalSort() {
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false) {
                topologicalSortUtil(key, visited, ans);
            }
        }
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
    }

    public void topologicalSortUtil(int v, HashMap<Integer, Boolean> visited, Stack<Integer> ans) {
        visited.put(v, true);
        for (GraphNode neighbor : graph.get(v).neighbors) {
            if (visited.get(neighbor.label) == false) {
                topologicalSortUtil(neighbor.label, visited, ans);
            }
        }
        ans.add(v);
    }

}
