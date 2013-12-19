package FreePractise;

import java.util.Arrays;

public class QuickSort {
    
    public static int partition(int[] data, int pivot, int left, int right) {
        int leftIter = left;
        int rightIter = right;
        int middleData = data[pivot];
        while (true) {
            while (data[leftIter] < middleData)
                leftIter++;
            while (data[rightIter] > middleData)
                rightIter--;
            if (leftIter < rightIter) {
                int temp = data[rightIter];
                data[rightIter] = data[leftIter];
                data[leftIter] = temp;
                if (data[leftIter] == middleData)
                    leftIter++;
            } else
                break;
        }
        return leftIter - 1;
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int middleBoundary = partition(data, left, left, right);
            if (middleBoundary > left && middleBoundary < right) {
                if ((middleBoundary - left) > 1)
                    quickSort(data, left, middleBoundary);
                if ((right - middleBoundary) > 1)
                    quickSort(data, middleBoundary + 1, right);
            }
        }
        return;
    }

    public static void main(String[] args) {
        //        int[] testData = new int[] { 1, 3, 6, 3, 7, 6, 2, 1, 9 };
        int[] testData = new int[] { 23, 44, 1, 2009, 2, 88, 123, 7, 999, 1040, 88, 88, 123, 44 };
        quickSort(testData, 0, testData.length - 1);
        System.out.println(Arrays.toString(testData));
    }
}
