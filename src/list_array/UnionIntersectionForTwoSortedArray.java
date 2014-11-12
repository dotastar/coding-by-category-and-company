/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   UnionIntersectionForTwoSortedArray.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to get union and intersection for two sorted array
 *                    
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class UnionIntersectionForTwoSortedArray {
    public void printUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i++] + " ");
            } else if (arr1[j] < arr2[i]) {
                System.out.print(arr2[j++] + " ");
            } else {
                System.out.print(arr2[j++] + " ");
                i++;
            }
        }
        while (i < arr1.length) {
            System.out.print(arr1[i++] + " ");
        }
        while (j < arr2.length) {
            System.out.print(arr2[j++] + " ");
        }
    }

    public void printIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[j] < arr2[i]) {
                j++;
            } else {
                System.out.print(arr2[j++] + " ");
                i++;
            }
        }
    }

}
