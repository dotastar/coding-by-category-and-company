/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DetectCycleInUndirectedGraph.java
 *         Created:   Oct 24, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Use disjointSet to detect cycle in a undirected graph(cannot have self-loops).
 *                    
 * All rights reserved.
 ******************************************************************************/
package unionfind;

import java.util.HashMap;
import java.util.Map;

import util.EdgeGraph;

public class DetectCycleInUndirectGraph {
    public boolean isCycle(EdgeGraph g) {
        int[] set = new int[g.V];
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < g.E; i++) {
            int src = g.edges.get(i).src, dec = g.edges.get(i).dec;
            if (!idxMap.containsKey(src)) {
                idxMap.put(src, idxMap.size());
            }
            if (!idxMap.containsKey(dec)) {
                idxMap.put(dec, idxMap.size());
            }
        }
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
        for (int i = 0; i < g.E; i++) {
            int r1 = findRoot(set, idxMap.get(g.edges.get(i).src));
            int r2 = findRoot(set, idxMap.get(g.edges.get(i).dec));
            if (r1 == r2) {
                return true;
            }
            union(set, r1, r2);
        }
        return false;
    }

    public int findRoot(int[] set, int i) {
        while (i != set[i]) {
            set[i] = set[set[i]];//optimize
            i = set[i];
        }
        return i;
    }

    void union(int[] set, int i, int j) {
        int r1 = findRoot(set, i), r2 = findRoot(set, j);
        set[r1] = r2;
    }
}
