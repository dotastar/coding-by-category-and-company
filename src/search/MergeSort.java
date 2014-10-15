package search;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int[] firstHalf = new int[array.length / 2];
        int[] secondHalf = new int[array.length - array.length / 2];
        System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, secondHalf, 0, array.length - array.length / 2);
        return merge(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    public static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] ans = new int[firstHalf.length + secondHalf.length];
        int pos1 = 0, pos2 = 0, pos = 0;
        while (pos1 < firstHalf.length && pos2 < secondHalf.length) {
            if (firstHalf[pos1] <= secondHalf[pos2]) {
                ans[pos++] = firstHalf[pos1++];
            } else {
                ans[pos++] = secondHalf[pos2++];
            }
        }
        while (pos1 < firstHalf.length) {
            ans[pos++] = firstHalf[pos1++];
        }
        while (pos2 < secondHalf.length) {
            ans[pos++] = secondHalf[pos2++];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] ans = MergeSort.mergeSort(new int[]{3, 3, 4, 0, 5, 0, 3, 1});
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
