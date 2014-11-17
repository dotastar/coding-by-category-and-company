/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PrefixReprerentWord.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Use the shortest unique prefix to represent each word in the array 
 *                    input: ["zebra", "dog", "duck","dot"] 
 *                    output: {zebra: z, dog: do, duck: du}  
 *                    
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinPrefixReprerentWord {
    public class Node {
        boolean stop = false;
        int counter = 0;
        HashMap<Character, Node> children = new HashMap<Character, Node>();
    }

    public Node buildTrie(ArrayList<String> input) {
        Node root = new Node();
        for (String word : input) {
            Node cur = root, child = null;
            for (char ch : word.toCharArray()) {
                if (cur.children.containsKey(ch)) {
                    child = cur.children.get(ch);
                } else {
                    child = new Node();
                    cur.children.put(ch, child);
                }
                cur.children.get(ch).counter++;
                cur = child;
            }
            cur.stop = true;
        }
        return root;
    }

    public HashMap<String, String> startSearch(Node root) {
        HashMap<String, String> res = new HashMap<String, String>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Node> iter : root.children.entrySet()) {
            sb.setLength(0);
            sb.append(iter.getKey());
            search(res, iter.getValue(), sb);
        }
        return res;
    }

    public void search(HashMap<String, String> res, Node root, StringBuilder prefix) {
        if (root.counter == 1) {
            StringBuilder word = new StringBuilder();
            word.append(prefix);
            while (root.children.size() > 0) {
                //NOTE there is only one child here, since counter == 1
                for (Map.Entry<Character, Node> iter : root.children.entrySet()) {
                    word.append(iter.getKey());
                    root = iter.getValue();
                }
            }
            res.put(prefix.toString(), word.toString());
            return;
        }
        if (root.stop == true) {//NOTE
            res.put(prefix.toString(), prefix.toString());
            return;
        }
        for (Map.Entry<Character, Node> iter : root.children.entrySet()) {
            prefix.append(iter.getKey());
            search(res, iter.getValue(), prefix);
        }
    }
}
