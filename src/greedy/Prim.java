/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Prim.java
 *         Created:   Oct 24, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   implement Prim MST Algorithm in adjacent matrix
 *                    http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/ 
 *                    If we want implement it in adjacent list, we need a priorityqueue
 * All rights reserved.
 ******************************************************************************/
package greedy;

import java.util.Arrays;

public class Prim {
    public void primMST(int[][] graph) {
        int[] parent = new int[graph.length];//Array to store constructed MST
        int[] dis = new int[graph.length];//values used to pick minimum weight edge in cut
        boolean[] mstSet = new boolean[graph.length];//mstSet[i] will be true, if vertex i is included in mstSet
        Arrays.fill(mstSet, false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        for (int i = 0; i < graph.length - 1; i++) {
            int idx = minDis(dis, mstSet);
            mstSet[idx] = true;
            for (int v = 0; v < graph.length; v++) {
                if (graph[idx][v] > 0 && mstSet[v] == false && graph[idx][v] < dis[v]) {
                    parent[v] = idx;
                    dis[v] = graph[idx][v];
                }
            }
        }
        printMST(parent, graph);
    }

    public void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " " + i + "     " + graph[i][parent[i]]);
        }
    }

    public int minDis(int[] dis, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIdx = 0;
        for (int i = 0; i < dis.length; i++)
            if (mstSet[i] == false && dis[i] < min) {//NOTE
                min = dis[i];
                minIdx = i;
            }
        return minIdx;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }, };// 0 means no edge between these two nodes
        Prim test = new Prim();
        test.primMST(graph);
    }
}
