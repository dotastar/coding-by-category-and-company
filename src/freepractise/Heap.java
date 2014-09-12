package freepractise;

public class Heap {
    public static void heapSort(int[] array) {
        for (int i = array.length / 2; i >= 1; i--) {//i is root_id, and start from 1 to n/2
            heapifyDown(array, i, array.length);
        }
        for (int i = array.length; i >= 2; i--) {
            swap(array, i - 1, 0);
            heapifyDown(array, 1, i - 1);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void heapifyDown(int[] array, int root, int end) {//NOTE treeNode_Id can't exceed end
        while (root <= end / 2) {
            int lower = 0;
            if (root * 2 + 1 <= end && array[root * 2 + 1 - 1] >= array[root * 2 - 1]) {//NOTE means the right-child exists!
                lower = root * 2 + 1;
            } else {
                lower = root * 2;
            }
            if (array[lower - 1] > array[root - 1]) {
                swap(array, lower - 1, root - 1);
                root = lower;
            } else {
                break;
            }
        }
    }

    public static void heapifyUp(int[] array, int root, int end) {//NOTE heapifyUp the end!, root start from 1
        while (end >= root * 2) {
            if (array[end - 1] > array[end / 2 - 1]) {
                swap(array, end - 1, end / 2 - 1);
                end = end / 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] { 3, 4, 4, 6, 3, 0, 7 };
        Heap.heapSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("------------");
        for (int i = test.length / 2; i >= 1; i--) {//i is root_id, and start from 1 to n/2
            heapifyDown(test, i, test.length);
        }
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("------------");
        int[] newArray = new int[test.length + 1];
        System.arraycopy(test, 0, newArray, 0, test.length);
        newArray[newArray.length - 1] = 100;
        Heap.heapifyUp(newArray, 1, newArray.length);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}