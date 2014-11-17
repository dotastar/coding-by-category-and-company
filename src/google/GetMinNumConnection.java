/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   GetMinNumConnection.java
 *         Created:   Nov 15, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a list int string, connect them to form a number which is minimum
 *                    n=4 nums: ["54", "546", "548", "60"]  output is "5454654860"
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.ArrayList;
import java.util.Collections;

public class GetMinNumConnection {
    public class Node implements Comparable<Node> {
        public char[] data;

        public Node(String str) {
            data = str.toCharArray();
        }

        @Override
        public int compareTo(Node o) {
            int i = 0, j = 0;
            while (i < this.data.length && j < o.data.length) {
                if (this.data[i] < o.data[j]) {
                    return -1;
                } else if (this.data[i] > o.data[j]) {
                    return 1;
                }
                i++;
                j++;
            }
            if (i < this.data.length) {
                return 1;
            }
            if (j < o.data.length) {
                return -1;
            }
            return 0;
        }
    }

    public String connect(String[] ints) {
        ArrayList<Node> data = new ArrayList<Node>();
        for (int i = 0; i < ints.length; i++) {
            data.add(new Node(ints[i]));
        }
        Collections.sort(data);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            ans.append(data.get(i).data);
        }
        return ans.toString();
    }
    
    public static void main(String[] args) {
        String[] data = new String[]{"54", "546", "548", "60"};
        GetMinNumConnection test = new GetMinNumConnection();
        System.out.println(test.connect(data));
    }
}
