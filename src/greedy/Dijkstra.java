/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Dijkstra.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Dijkstra's shortest path algorithm applied in adjacent matrix(without negative weight)
 *                    http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * All rights reserved.
 ******************************************************************************/
package greedy;

import java.util.Arrays;

public class Dijkstra {
    public void dijkstra(int[][] graph, int src) {
        int[] dis = new int[graph.length];//The output array. dist[i] will hold the shortest dist from src to i
        boolean[] sptSet = new boolean[graph.length];//sptSet[i] will be true, if vertex i is included in mstSet
        Arrays.fill(sptSet, false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i < graph.length - 1; i++) {//NOTE
            int idx = minDis(dis, sptSet);
            sptSet[idx] = true;
            for (int v = 0; v < graph.length; v++) {
                if (sptSet[v] == false && graph[idx][v] > 0 && dis[idx] < Integer.MAX_VALUE//in case of vertex idx is a isolated vertex
                        && dis[idx] + graph[idx][v] < dis[v]) {
                    dis[v] = dis[idx] + graph[idx][v];
                }
            }
        }
        printSol(dis);
    }

    public int minDis(int[] dis, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIdx = 0;
        for (int i = 0; i < dis.length; i++)
            if (sptSet[i] == false && dis[i] < min) {//NOTE
                min = dis[i];
                minIdx = i;
            }
        return minIdx;
    }

    public void printSol(int[] dis) {
        for (int i = 0; i < dis.length; i++) {
            System.out.println(i + " " + dis[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra test = new Dijkstra();
        test.dijkstra(graph, 0);
    }
}
