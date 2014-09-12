/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SearchSmallestLargerChar.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32763769.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

public class SearchSmallestLargerChar {
    char search(char[] list, char target) {
        int l = 0, r = list.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list[mid] == target) {
                int rbound = mid;
                while ((mid = binarySearch(list, target, mid + 1, r)) != -1) {
                    rbound = mid;
                }
                return list[(rbound + 1) % list.length];
            } else if (list[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return list[l % list.length];
    }

    public int binarySearch(char A[], int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchSmallestLargerChar test = new SearchSmallestLargerChar();
        char[] a1 = {'c', 'f', 'j', 'p', 'v'};
        System.out.println(test.search(a1, 'a'));
        char[] a2 = {'c', 'f', 'j', 'p', 'v'};
        System.out.println(test.search(a2, 'c'));
        char[] a3 = {'c', 'f', 'j', 'p', 'v'};
        System.out.println(test.search(a3, 'z'));
        char[] a4 = {'c', 'c', 'c', 'c', 'c', 'f', 'k'};
        System.out.println(test.search(a4, 'c'));
        char[] a5 = {'a', 'b', 'b', 'c', 'c', 'c', 'c'};
        System.out.println(test.search(a5, 'c'));
    }
}
