/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StronglyConnectedComponents.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a directed graph, find out whether the graph is strongly connected or not. 
 *                    A directed graph is strongly connected if there is a path between any two pair of vertices.
 *                    We can find all SCCs in O(V+E) time. If number of SCCs is one, then graph is strongly connected. 
 *                    1. Initialize all vertices as not visited.
 *                    2. Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS traversal doesn't visit all vertices, then return false.
 *                    3. Reverse all arcs (or find transpose or reverse of graph)
 *                       Mark all vertices as not-visited in reversed graph.
 *                    4. Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). If DFS traversal doesn't visit all vertices, then return false. Otherwise return true.
 *                    The idea is, if every node can be reached from a vertex v, and every node can reach v, then the graph is strongly connected.
 *                    In step 2, we check if all vertices are reachable from v.
 *                    In step 4, we check if all vertices can reach v (In reversed graph, if all vertices are reachable from v, then all vertices can reach v in original graph).
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import util.GraphNode;


public class StronglyConnectedGraph {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

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

    public void bfsUtil(int v, HashMap<Integer, Boolean> visited) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            visited.put(cur, true);
            for (GraphNode adj : graph.get(cur).adjs) {
                if (visited.get(adj.label) == false) {
                    queue.add(adj.label);
                }
            }
        }
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

    public boolean isSCG(int v) {
        bfsUtil(v, visited);
        for (Map.Entry<Integer, Boolean> iter : visited.entrySet()) {
            if (iter.getValue() == false) {
                return false;
            }
        }
        reverseGraph();
        bfsUtil(v, visited);
        for (Map.Entry<Integer, Boolean> iter : visited.entrySet()) {
            if (iter.getValue() == false) {
                return false;
            }
        }
        return true;
    }
}
