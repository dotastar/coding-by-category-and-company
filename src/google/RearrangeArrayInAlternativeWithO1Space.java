/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RearrangeArrayInAlternativeWithO1Space.java
 *         Created:   Nov 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Rearrange array in alternating positive & negative items with O(1) extra space
 *                    such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
 *                    NOTE The idea is to process array from left to right.
 *                    While processing, find the first out of place element in the remaining unprocessed array.
 *                    An element is out of place if it is negative and at odd index, or it is positive and at even index. Once we find an out of place element, we find the first element after it with opposite sign. We right rotate the subarray between these two elements (including these two).
 *                    then rotate (-3 is out of position): [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
 * All rights reserved.
 ******************************************************************************/
package google;

public class RearrangeArrayInAlternativeWithO1Space {

    void rightrotate(int arr[], int n, int outofplace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }

    void rearrange(int arr[], int n) {
        int outofplace = -1;
        for (int index = 0; index < n; index++) {
            if (outofplace >= 0) {
                if (((arr[index] >= 0) && (arr[outofplace] < 0)) || ((arr[index] < 0) && (arr[outofplace] >= 0))) {
                    rightrotate(arr, n, outofplace, index);
                    if (index - outofplace >= 2)//NTOE
                        outofplace = outofplace + 2;
                    else{//NOTE think why?
                        outofplace = -1;
                    }
                }
            }
            // if no entry has been flagged out-of-place
            if (outofplace == -1) {
                if (((arr[index] >= 0) && ((index & 0x01) == 0)) || ((arr[index] < 0) && (index & 0x01) == 1)) {
                    outofplace = index;
                }
            }
        }
    }

    public static void main(String[] args) {
        RearrangeArrayInAlternativeWithO1Space test = new RearrangeArrayInAlternativeWithO1Space();
        int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        test.rearrange(arr, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
