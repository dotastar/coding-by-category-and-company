/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SearchCutVertices.java
 *         Created:   Nov 9, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   A vertex in an undirected connected graph is an articulation point (or cut vertex) iff removing it (and edges through it) disconnects the graph.
 *                    They are useful for designing reliable networks.
 *                    For a disconnected undirected graph, an articulation point is a vertex removing which increases number of connected components.
 *                    In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
 *                    1. u is root of DFS tree and it has at least two children.
 *                    2. u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
 *                    Refer: http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.ArrayList;
import java.util.HashMap;

import util.GraphNode;

public class SearchCutVertices {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    private int time = 0;

    public void addEdge(int v, int w) {
        if (!graph.containsKey(v)) {
            graph.put(v, new GraphNode(v));
        }
        if (!graph.containsKey(w)) {
            graph.put(w, new GraphNode(w));
        }
        graph.get(v).adjs.add(graph.get(w));
        graph.get(w).adjs.add(graph.get(v));
        visited.put(v, false);
        visited.put(w, false);
    }

    public ArrayList<GraphNode> serchCutNodes() {
        ArrayList<GraphNode> ans = new ArrayList<GraphNode>();
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false) {
                this.time = 0;
                search(key, visited, new HashMap<Integer, Integer>(), new HashMap<Integer, Integer>(),
                        new HashMap<Integer, Integer>(), ans);
            }
        }
        return ans;
    }

    public void search(int u, HashMap<Integer, Boolean> visited, HashMap<Integer, Integer> disc,
            HashMap<Integer, Integer> low, HashMap<Integer, Integer> parent, ArrayList<GraphNode> ans) {
        int children = 0;
        visited.put(u, true);
        disc.put(u, this.time);
        low.put(u, this.time);
        this.time++;
        for (GraphNode adj : graph.get(u).adjs) {
            if (visited.get(adj.label) == false) {
                parent.put(adj.label, u);
                search(adj.label, visited, disc, low, parent, ans);
                low.put(u, Math.min(low.get(u), low.get(adj.label)));
                if(!parent.containsKey(u) && children > 1){
                    ans.add(graph.get(u));
                }
                if(parent.containsKey(u) && low.get(adj.label) >= disc.get(u)){
                    ans.add(graph.get(u));
                }
            }else if(adj.label != parent.get(u)){
                low.put(u, Math.min(low.get(u), disc.get(adj.label)));
            }
        }
    }
}
