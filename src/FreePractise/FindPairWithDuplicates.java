package freepractise;

import java.util.Arrays;
import java.util.HashMap;

public class FindPairWithDuplicates {

    /**
     * given a fixed number, find the number of pairs in array, which can satisfy this condition;
     * eg. 1, 1, 1, 4, 4, 4; the sum is 5; so the #ofPairs is 9 (consider the duplicates)
     * this is solution is use hashmap in a direct easy way (which need need scan the hashmap)
     * 
     * @param src
     * @param con
     * @return
     */
    public static int findPairWithDuplicates1(int[] src, int con) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < src.length; i++) {
            if (map.containsKey(src[i])) {
                map.put(src[i], map.get(src[i]) + 1);
            } else {
                map.put(src[i], 1);
            }
        }
        int num = 0;
        for (Integer iter : map.keySet()) {
            if (iter == (con - iter)) { //NOTE: {3,3,3,3}, given 6
                int temp = map.get(iter);
                int sum = 0;
                for (int i = temp - 1; i >= 0; i--) {
                    sum += i;
                }
                num += sum * 2;
            } else if (map.containsKey(con - iter)) {
                num += map.get(iter) * map.get(con - iter);
            }
        }
        return num / 2;
    }

    /**
     * this solution come from ChangJian, which use hashmap but don't scan it
     * the key is use: Distributive law of multiplication!!!!
     * this solution's advantage is determine the order when forming to pair (eg. {3,3,3,3} given 6)
     * 
     * @param src
     * @param con
     * @return
     */
    public static int findPairWithDuplicates2(int[] src, int con) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num = 0;
        for (int i = 0; i < src.length; i++) {
            if (map.containsKey(con - src[i])) {
                num += map.get(con - src[i]);
            }
            if (map.containsKey(src[i])) {
                map.put(src[i], map.get(src[i]) + 1);
            } else {
                map.put(src[i], 1);
            }
        }
        return num; //NOTE: don't need to divide 2; cause each use distributive law of multiplication
    }

    /**
     * this solution is use sorting which need the O(1) space
     * 
     * @param src
     * @param con
     * @return
     */
    public static int findPairWithDuplicates3(int[] src, int con) {
        Arrays.sort(src);
        int i = 0;
        int j = src.length - 1;
        int countI = 0;
        int countJ = 0;
        int sum = 0;
        while (i < j) {
            if (src[i] + src[j] < con) {
                i++;
            } else if (src[i] + src[j] > con) {
                j--;
            } else {
                countI = 1;
                countJ = 1;
                if (src[i] == (con - src[i])) //NOTE: must be careful with {3,3,3,3} given 6
                    break;
                while (i < src.length - 1 && src[i + 1] == src[i]) { //NOTE: can not write src[i + 1] == src[i] && i < src.length - 1, this situation is easily to report arrayOffset exception
                    i++;
                    countI++;
                }
                while (j > 0 && src[j - 1] == src[j]) {
                    j--;
                    countJ++;
                }
                sum += countI * countJ;
                i++;
                j--;
            }
        }
        if (src[i] == (con - src[i])) {
            sum += processDupI(src, i, con);
        }
        return sum;
    }

    public static int processDupI(int[] src, int index, int con) {
        int dup = 0;
        int sum = 0;
        while (index < src.length && src[index] == (con - src[index])) { //NOTE:
            dup++;
            index++;
        }
        for (int i = dup - 1; i >= 0; i--) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = { 1, 1, 1, 4, 2, 2, 3, 3 };
        int[] test2 = { 3, 3, 3, 3 };
        //        System.out.println(FindPairWithDuplicates.findPairWithDuplicates1(test2, 6));
        //        System.out.println(FindPairWithDuplicates.findPairWithDuplicates2(test2, 6));
        System.out.println(FindPairWithDuplicates.findPairWithDuplicates3(test2, 6));
    }
}
