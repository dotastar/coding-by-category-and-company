/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TwoDBIT.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   2D-BIT applies for range query and single point update for matrix
 *                    eg. how to query the total number of points in a specific rectangle of the matrix
 * All rights reserved.
 ******************************************************************************/
package binaryindexedtree;

public class TwoDBIT {
    int[][] tree;
    
    public TwoDBIT(int N){
        tree = new int[N][N];
    }
    
    public int getLowbit(int n){
        return n & (-n);
    }
    
    //read first (i, j) entries'sum, idx from 1 instead of 0
    public int read(int i, int j){
        int sum = 0, k = j;
        for(; i > 0; i -= getLowbit(i)){
            for(j = k; j > 0; j-=getLowbit(j)){
                sum += tree[i][j];
            }
        }
        return sum;
    }
    
    //update specific element in data matrix, but idx start from 1 instead of 0
    public void update(int i, int j, int val){
        int k = j;
        for(; i < tree.length; i+= getLowbit(i)){
            for(j = k; j < tree.length; j += getLowbit(j)){
                tree[i][j] += val;
            }
        }
    }
}
