/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DetectCycleInDirectedGraph.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Check whether a directed graph contains cycle.
 *                    Notice:  1 <-- 2 --> 4 don't contain a cycle
 *                               \>  3  </ 
 *                    So we need path set to record current path in a graph
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.HashSet;

import util.GraphNode;

public class DetectCycleInDirectedGraph {
    HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    HashSet<Integer> path = new HashSet<Integer>();//NOTE
    
    public void addEdge(int v, int w){
        if(!graph.containsKey(v)){
            graph.put(v, new GraphNode(v));
        }
        if(!graph.containsKey(w)){
            graph.put(w, new GraphNode(w));
        }
        graph.get(v).adjs.add(graph.get(w));
        visited.put(v, false);
        visited.put(w, false);
    }
    
    public boolean isCyclic(){
        for (Integer key : graph.keySet()) {
            if (visited.get(key) == false && isCyclicUtil(key, visited, path)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCyclicUtil(int v, HashMap<Integer, Boolean> visited, HashSet<Integer> rec){
        visited.put(v, true);
        rec.add(v);
        for (GraphNode adj : graph.get(v).adjs) {
            if (visited.get(adj.label) == false && isCyclicUtil(adj.label, visited, rec)) {
                return true;
            }else if(rec.contains(adj.label)){
                return true;
            }
        }
        rec.remove(v);
        return false;
    }
}
