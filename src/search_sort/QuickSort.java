package search_sort;

import java.util.Arrays;

public class QuickSort {
    
    public static void quickSort(int[] data, int start, int end){
        if(start >= end){
            return;
        }
        int mid = partition(data, start, end);
        quickSort(data, start, mid - 1);
        quickSort(data, mid + 1, end);
    }
    
    public static int partition(int[] data, int start, int end){
        int i = start + 1, j = end;
        while(i <= j){//NOTE think about why has a '='.
            if(data[i] < data[start]){
                i++;
                continue;//NOTE in case of crossing the border
            }
            if(data[j] >= data[start]){
                j--;
                continue;
            }
            swap(data, i, j);
        }
        swap(data, start, j);
        return j;
    }
    
    public static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] testData = new int[] { 23, 44, 1, 2009, 2, 88, 123, 7, 999, 1040, 88, 88, 123, 44 };
        quickSort(testData, 0, testData.length - 1);
        System.out.println(Arrays.toString(testData));
    }
}
