/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckGraphBipartite.java
 *         Created:   Nov 8, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Check wheterh a given graph is Bipartite or not 
 *                    One approach is to check whether the graph is 2-colorable or not using backtracking algorithm m coloring problem.
 *                    Following is a simple algorithm to find out whether a given graph is Birpartite or not using Breadth First Search (BFS).
 *                    1.  Assign RED color to the source vertex (putting into set U).
 *                    2.  Color all the neighbors with BLUE color (putting into set V).
 *                    3.  Color all neighbor's neighbor with RED color (putting into set U).
 *                    4.  This way, assign color to all vertices such that it satisfies all the constraints of m way coloring problem where m = 2.
 *                    5. While assigning colors, if we find a neighbor which is colored with same color as current vertex, then the graph cannot be colored with 2 vertices (or graph is not Bipartite)
 *                    Refer: http://www.geeksforgeeks.org/bipartite-graph/
 * All rights reserved.
 ******************************************************************************/
package graph;

import java.util.LinkedList;

public class CheckGraphBipartite {
    public boolean isBipartite(int[][] graph, int src) {
        int[] color = new int[graph.length];
        color[src] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (graph[u][v] == 1 && color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
