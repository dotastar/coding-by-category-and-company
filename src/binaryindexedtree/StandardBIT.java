/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StandardBIT.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Please refer: http://www.hawstein.com/posts/binary-indexed-trees.html
 *                    Or EVERNOTE_Advanced DataStructure
 *                    basic operations for BIT. 
 *                    NOTE we move idx from 0 to 1, which means tree[1] = data[0]
 *                    when we want to get sum in [i, j], we only need to perform read(j + 1) - read(i)
 * All rights reserved.
 ******************************************************************************/
package binaryindexedtree;

public class StandardBIT {
    int[] tree;
    
    //build BIT in time O(n)
    public StandardBIT(int[] data){
        tree = new int[data.length + 1];//move idx from 0 to 1
        int[] prefixSum = new int[data.length + 1];//move idx from 0 to 1
        for(int i = 1; i <= data.length; i++){
            prefixSum[i] = prefixSum[i - 1] + data[i - 1];
        }
        for(int i = 1; i <= data.length; i++){
            int lowbit = getLowbit(i);
            if(lowbit == i){
                tree[i] = prefixSum[i];
            }else{
                tree[i] = prefixSum[i] - prefixSum[i - lowbit];
            }
        }
    }
    
    public int getLowbit(int n){
        return n & (-n);
    }
    
    //read first idx entries'sum, idx from 1 to data.length
    public int read(int idx){
        int sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= getLowbit(idx);
        }
        return sum;
    }
    
    //update specific element in data array, but idx start from 1 to data.length
    public void update(int idx, int val){
        while(idx < tree.length){
            tree[idx] += val;
            idx += getLowbit(idx);
        }
    }
}
