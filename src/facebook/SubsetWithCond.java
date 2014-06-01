/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SubsetWithCond.java
 *         Version:   1.0
 *         Created:   5/26 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   abbc, [a,b,c] ->  a, b, c, ab, abb, bbc, bb, bc;
 *                    each subset should not cover all the distinct letters of the original char string.
 *            
 * All rights reserved.
 ******************************************************************************/

package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubsetWithCond {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> unique = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
                unique.add(num[i]);
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        search(map, unique, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void search(HashMap<Integer, Integer> map, ArrayList<Integer> unique, int idx, ArrayList<Integer> cal,
            ArrayList<ArrayList<Integer>> ans) {
        if(idx == unique.size()){
            ans.add(new ArrayList<Integer>(cal));
            return;
        }
        for(int i = 0; i < map.get(unique.get(idx)); i++){
            search(map, unique, idx + 1, cal, ans);
            cal.add(unique.get(idx));
        }
        search(map, unique, idx + 1, cal, ans);
        for(int i = 0; i < map.get(unique.get(idx)); i++){
            cal.remove(cal.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
