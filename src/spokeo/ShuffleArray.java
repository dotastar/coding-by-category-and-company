/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ShuffleArray.java
 *         Version:   1.0
 *         Created:   3/1 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to shuffle array in possibility 1/k(k is number of unique permutations(array may have duplicates))
 *            
 * All rights reserved.
 ******************************************************************************/
package spokeo;

public class ShuffleArray {
    /**
     * 1. If all elements are unique in array, 1/k = 1/n! = 1/n * 1/n-1 * 1/n-2.....1
     * 2. If array has duplicates, 1/k = (a!b!..)/n!, formula:1/n * 1/n-1 * 1/n-2.....1 still works, think about it!
     * 
     * @param array
     */
    public void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i + (int) Math.random() * ((array.length - 1) - i + 1);// Math.random() -> [0, 1) Math.random * (max - min)-> [0, max-min)
            swap(array, i, pos);
        }
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
