package search;

public class QuickSelection {
    public static int quickSelection(int[] data, int k, int start, int end) {
        if (start >= end) {
            if (start == end && k == 0) {
                return data[start];
            }
            return -1;
        }
        int pivot = partition(data, start, end);
        if (k == pivot - start) {
            return data[pivot];
        } else if (k < pivot - start) {
            return quickSelection(data, k, start, pivot - 1);
        } else {
            return quickSelection(data, k - (pivot - start + 1), pivot + 1, end);
        }
    }

    public static int partition(int[] data, int start, int end) {
        int i = start + 1, j = end;
        while (i <= j) {
            if (data[i] < data[start]) {
                i++;
                continue;
            }
            if (data[j] >= data[start]) {
                j--;
                continue;
            }
            swap(data, i, j);
        }
        swap(data, start, j);
        return j;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(QuickSelection.quickSelection(new int[] { 4, 4, 3, 2, 3, 1 }, 5, 0, 5));
    }
}
