/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StrongConnectedComponents.java
 *         Created:   Nov 9, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   A directed graph is strongly connected if there is a path between all pairs of vertices.
 *                    A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.
 *                    Refer: http://www.geeksforgeeks.org/strongly-connected-components/
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import util.GraphNode;

public class StrongConnectedComponents {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    Stack<Integer> stack = new Stack<Integer>();

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

    public void reverseGraph() {
        HashMap<Integer, GraphNode> newGraph = new HashMap<Integer, GraphNode>();
        HashMap<Integer, Boolean> newVisited = new HashMap<Integer, Boolean>();
        for (Map.Entry<Integer, GraphNode> iter : graph.entrySet()) {
            for (GraphNode neighbor : iter.getValue().adjs) {
                if (!newGraph.containsKey(neighbor.label)) {
                    newGraph.put(neighbor.label, new GraphNode(neighbor.label));
                }
                if (!newGraph.containsKey(iter.getKey())) {
                    newGraph.put(iter.getKey(), new GraphNode(iter.getKey()));
                }
                newGraph.get(neighbor.label).adjs.add(newGraph.get(iter.getKey()));
                newVisited.put(neighbor.label, false);
                newVisited.put(iter.getKey(), false);
            }
        }
        graph.clear();
        visited.clear();
        graph.putAll(newGraph);
        visited.putAll(newVisited);
    }

    public void fillOrder(int v, HashMap<Integer, Boolean> visited, Stack<Integer> ans) {
        visited.put(v, true);
        for (GraphNode adj : graph.get(v).adjs) {
            if (visited.get(adj.label) == false) {
                fillOrder(adj.label, visited, ans);
            }
        }
        ans.add(v);
    }

    public void dfsUtil(int v, HashMap<Integer, Boolean> visited) {
        visited.put(v, true);
        System.out.print(v + " ");
        for (GraphNode neighbor : graph.get(v).adjs) {
            if (visited.get(neighbor.label) == false) {
                dfsUtil(neighbor.label, visited);
            }
        }
    }

    public void printSCCs() {
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false) {
                fillOrder(key, visited, stack);
            }
        }
        reverseGraph();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited.get(v) == false) {
                dfsUtil(v, visited);
                System.out.println();
            }
        }
    }
}
