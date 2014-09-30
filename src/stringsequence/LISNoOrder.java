/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LISNoOrder.java
 *         Created:   Sep 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   CTCI 9.10 we use DP(aka. 2nd solution) to solve it! tc is around O(n + e)(like traverse a graph) also O(n^2)
 *                    please see http://www.felix021.com/blog/read.php?1587
 *                    this problem allow use to sort it at first!!! it's not like a subsequence!
 * All rights reserved.
 ******************************************************************************/
package stringsequence;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LISNoOrder {
    public static class Bottle implements Comparable<Bottle> {
        int width;
        int depth;
        int height;

        public int hashcode() {
            return width * 311 + depth * 157 + height;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Bottle)) {
                return false;
            }
            Bottle other = (Bottle) obj;
            if (this.width == other.width && this.depth == other.height && this.height == other.height) {
                return true;
            } else {
                return false;
            }
        }

        public Bottle(int width, int depth, int height) {
            this.width = width;
            this.depth = depth;
            this.height = height;
        }

        public boolean isBefore(Bottle other) {
            if ((this.width < other.width) && (this.depth < other.depth) && (this.height < other.height)) {
                return true;
            } else
                return false;
        }

        @Override
        public int compareTo(Bottle o) {
            if (this.height == o.height) {
                if (this.width == o.width) {
                    return (this.depth < o.depth) ? -1 : ((this.depth == o.depth) ? 0 : 1);
                }
                return (this.width < o.width) ? -1 : ((this.width == o.width) ? 0 : 1);
            }
            return (this.height < o.height) ? -1 : ((this.height == o.height) ? 0 : 1);
        }
    }

    public static Stack<Bottle> getHighestStack(Bottle[] data) throws IOException{
        Arrays.sort(data);
        int maxIdx = -1, maxHeight = Integer.MIN_VALUE;
        HashMap<Bottle, Stack<Bottle>> map = new HashMap<Bottle, Stack<Bottle>>();
        for(int i = 0; i < data.length; i++){
            int curHeight = getHeightOfStack(search(data, i, map));
            if(curHeight > maxHeight){
                maxIdx = i;
                maxHeight = curHeight;
            }
        }
        return map.get(data[maxIdx]);
    }
    public static Stack<Bottle> search(Bottle[] data, int idx, HashMap<Bottle, Stack<Bottle>> cache)
            throws IOException {
        if (cache.containsKey(data[idx])) {
            return cache.get(data[idx]);
        }
        int maxIterHeight = 0;
        Stack<Bottle> maxIterStack = null;
        for (int i = 0; i < idx; i++) {//that's why we sort it at first!
            if (data[idx] != null && data[i].isBefore(data[idx])) {
                Stack<Bottle> iter = search(data, i, cache);
                int iterHeight = getHeightOfStack(iter);
                if (iterHeight > maxIterHeight) {
                    maxIterHeight = iterHeight;
                    maxIterStack = iter;
                }
            }
        }
        Stack<Bottle> curMaxStack = new Stack<Bottle>();
        curMaxStack.push(data[idx]);
        curMaxStack.addAll(maxIterStack);
        cache.put(data[idx], curMaxStack);
        return curMaxStack;
    }

    public static int getHeightOfStack(Stack<Bottle> stack) throws IOException {
        if (stack == null) {
            throw new IOException("null don't have height");
        }
        int ans = 0;
        for (int i = 0; i < stack.size(); i++) {
            ans += stack.get(i).height;
        }
        return ans;
    }

}
