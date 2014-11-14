/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PrintAllSubarraySumOf0.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array write a function to print all continuous subsequences in the array which sum of 0.
 *                    this array may contains negative and positive numbers
 *                    we use prefixSum to get the results in time O(n)
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintAllSubarraySumOf0 {
    public void printAllSubarray(int[] array){
        int[] prefisSum = new int[array.length + 1];//NOTE we need insert 0 in front of this array, think why?
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        prefisSum[1] = array[0];
        for(int i = 2; i < prefisSum.length; i++){
            prefisSum[i] = prefisSum[i - 1] + array[i - 1];
        }
        for(int i = 0; i < prefisSum.length; i++){
            if(!map.containsKey(prefisSum[i])){
                map.put(prefisSum[i], new ArrayList<Integer>());
            }else{
                for(Integer iter : map.get(prefisSum[i])){
                    System.out.println("(" + iter + ", " + (i-1) + ")");
                }
            }
            map.get(prefisSum[i]).add(i);
        }
    }
    
    public static void main(String[] args) {
        int[] data = new int[]{-1, -3, 4, 5, -2, -4, 6};
        PrintAllSubarraySumOf0 test = new PrintAllSubarraySumOf0();
        test.printAllSubarray(data);
    }
}
