/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CountInversion.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 *                    count how many inversions in a array  
 *                    we use divide and conquer to solve it by modifying merging sort in nlogn time
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class CountInversion {
    public int count(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int[] firstHalf = new int[array.length / 2];
        int[] secondHalf = new int[array.length - array.length / 2];
        System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, secondHalf, 0, array.length - array.length / 2);
        return count(firstHalf) + count(secondHalf) + merge(firstHalf, secondHalf, array);
    }
    
    public int merge(int[] firstHalf, int[] secondHalf, int[] merged) {
        int pos1 = 0, pos2 = 0, pos = 0, ans = 0;
        while (pos1 < firstHalf.length && pos2 < secondHalf.length) {
            if (firstHalf[pos1] <= secondHalf[pos2]) {
                merged[pos++] = firstHalf[pos1++];
            } else {
                ans += firstHalf.length - pos1;
                merged[pos++] = secondHalf[pos2++];
            }
        }
        while (pos1 < firstHalf.length) {
            merged[pos++] = firstHalf[pos1++];
        }
        while (pos2 < secondHalf.length) {
            merged[pos++] = secondHalf[pos2++];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        CountInversion test = new CountInversion();
        System.out.println(test.count(new int[]{2, 4, 1, 3, 5}));
    }
}
