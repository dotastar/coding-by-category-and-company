package parasoft;

public class question1 {
    
    /**
     * For example, given the following array:[10, -2, 5, 6, -5]
     * The possible values are: 8, 3, 11, 1, and the maximum value is 11.
     * @param src
     * @return
     */
    public static int getMaxValueFromConsecutiveValues(int[] src) {
        int temp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < src.length - 1; i++) {
            temp = src[i] + src[i + 1];
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
