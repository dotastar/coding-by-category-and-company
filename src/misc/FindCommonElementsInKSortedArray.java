package misc;

public class FindCommonElementsInKSortedArray {
    public static void find(int[][] input) {
        int[] ptrs = new int[input.length];
        for (; ptrs[0] < input[0].length; ptrs[0]++) {
            int cur = input[0][ptrs[0]];
            boolean isFind = true;
            for (int i = 1; i < ptrs.length; i++) {
                while (input[i][ptrs[i]] < cur && ptrs[i] < input[i].length - 1) {
                    ptrs[i]++;
                }
                if (input[i][ptrs[i]] != cur) {
                    isFind = false;
                }
            }
            if (isFind) {
                System.out.println(cur);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] data = {
                { 10, 160, 200, 500, 500, },
                { 4, 150, 160, 170, 500, },
                { 2, 160, 200, 202, 203, },
                { 3, 150, 155, 160, 300 },
                { 3, 150, 155, 160, 301 } };
        FindCommonElementsInKSortedArray.find(data);
    }
}
