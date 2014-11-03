/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   HamiltonCycle.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path
 *                    such that there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path.
 *                    Determine whether a given graph contains Hamiltonian Cycle or not.
 *                    A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
 * All rights reserved.
 ******************************************************************************/
package backtracking;

import java.util.ArrayList;

public class HamiltonCycle {
    boolean hamCycle(int[][] graph) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.get(0);
        if (check(graph, path, 0) == false) {
            return false;
        }
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        return true;
    }

    boolean check(int[][] graph, ArrayList<Integer> path, int pos) {
        if (pos == graph.length) {
            if (graph[path.get(path.size() - 1)][path.get(0)] == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int v = 1; v < graph.length; v++) {
            if (isSafe(v, graph, path)) {
                path.add(v);
                if (check(graph, path, pos + 1)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    boolean isSafe(int v, int[][] graph, ArrayList<Integer> path) {
        if (graph[path.get(path.size() - 1)][v] == 0) {
            return false;
        }
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == v) {
                return false;
            }
        }
        return true;
    }
}
