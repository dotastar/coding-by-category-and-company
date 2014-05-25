/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TwoDiff.java
 *         Version:   1.0
 *         Created:   5/22 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a target k, find all pairs which has array[i] - array[j] = k.
 *            
 * All rights reserved.
 ******************************************************************************/

package facebook;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoDiff {
    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * for the case, 2, 2, 3, 3 --> (2, 3) (2, 3)
     * @param array
     * @param target
     * @return
     */
    public static ArrayList<Pair> search1(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Pair> res = new ArrayList<Pair>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i] - target) != null && map.get(array[i] - target) > 0) {
                res.add(new Pair(array[i], array[i] - target));
                map.put(array[i] - target, map.get(array[i] - target) - 1);
                continue;
            }
            if (map.get(array[i] + target) != null && map.get(array[i] + target) > 0) {
                res.add(new Pair(array[i] + target, array[i]));
                map.put(array[i] + target, map.get(array[i] + target) - 1);
                continue;
            }
            map.put(array[i], map.get(array[i]) != null ? map.get(array[i]) + 1 : 1);
        }
        return res;
    }

    /**
     * for the case, 2, 2, 3, 3 --> (2, 3) (2, 3) (2, 3) (2, 3) 
     * @param array
     * @param target
     * @return
     */
    public static ArrayList<Pair> search2(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Pair> res = new ArrayList<Pair>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i] - target)) {
                for (int j = 0; j < map.get(array[i] - target); j++) {
                    res.add(new Pair(array[i], array[i] - target));
                }
            }
            if(array[i] - target != array[i] + target){//NOTE for target = 0
                if (map.containsKey(array[i] + target)) {
                    for (int j = 0; j < map.get(array[i] + target); j++) {
                        res.add(new Pair(array[i] + target, array[i]));
                    }
                }
            }
            map.put(array[i], map.get(array[i]) != null ? map.get(array[i]) + 1 : 1);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Pair> list = TwoDiff.search2(new int[] { 2, 3, 3, 1, 1 }, 0);
        for (Pair iter : list) {
            System.out.println(iter.x + " " + iter.y);
        }
    }
}
