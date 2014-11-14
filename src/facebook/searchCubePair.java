/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   searchCubePair.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Write all solutions for a^3+b^3 = c^3 + d^3, where a, b, c, d lie between [0, 10^5].
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

import java.util.ArrayList;
import java.util.HashMap;

public class searchCubePair {
    public class Pair {
        public int a;
        public int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void findSolutions(int N) {
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
        for (int a = 0; a < N; a++) {
            for (int b = a; b < N; b++) {
                int cube = (int) Math.pow(a, 3) + (int) Math.pow(b, 3);
                if (map.containsKey(cube)) {
                    for (Pair iter : map.get(cube)) {
                        System.out.println(iter.a + "^3 " + iter.b + "^3 " + "=" + a + "^3 " + b + "^3 ");
                    }
                } else {
                    map.put(cube, new ArrayList<Pair>());
                }
                map.get(cube).add(new Pair(a, b));
            }
        }
    }
}
