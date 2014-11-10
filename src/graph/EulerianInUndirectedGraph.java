/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   EulerianInUndirectedGraph.java
 *         Created:   Nov 9, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Eulerian Cycle
 *                    An undirected graph has Eulerian cycle if following two conditions are true.
 *                    1. All vertices with non-zero degree are connected. We don't care about vertices with zero degree because they don't belong to Eulerian Cycle or Path (we only consider all edges).
 *                    2. All vertices have even degree.
 *                    Eulerian Path
 *                    1. be same as above
 *                    2. f zero or two vertices have odd degree and all other vertices have even degree.
 *                    NOTE that only one vertex with odd degree is not possible in an undirected graph
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.HashMap;
import java.util.Map;

import util.GraphNode;

public class EulerianInUndirectedGraph {
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

    public void dfsUtil(int v, HashMap<Integer, Boolean> visited) {
        visited.put(v, true);
        for (GraphNode adj : graph.get(v).adjs) {
            if (visited.get(adj.label) == false) {
                dfsUtil(adj.label, visited);
            }
        }
    }

    public boolean isConnected() {
        for (Map.Entry<Integer, GraphNode> iter : graph.entrySet()) {
            if (iter.getValue().adjs.size() != 0) {
                dfsUtil(iter.getKey(), visited);
            }
        }
        for (Map.Entry<Integer, Boolean> iter : visited.entrySet()) {
            if (iter.getValue() == false && graph.get(iter.getKey()).adjs.size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    //0, if graph is not Eulerian
    //1, if graph is Eulerian cycle
    //2, if graph is Euler path
    public int isEulerian(){
        if(isConnected() == false){
            return 0;
        }
        int odd = 0;//Count vertices with odd degree
        for (Map.Entry<Integer, GraphNode> iter : graph.entrySet()) {
            if (iter.getValue().adjs.size() % 2 != 0) {
                odd++;
            }
        }
        if(odd > 2){//if count is more than 2, then graph is not Eulerian
            return 0;
        }
        //NOTE that odd count can never be 1 for undirected graph
        return odd == 0 ? 1 : 2;//if odd is 0, then Eulerian cycle; if odd is 2, then Euler path
    }
}
