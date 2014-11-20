/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   HashTableWithRamdomFunc.java
 *         Created:   Oct 21, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Data structure: insert, remove, contains, get random element, all at O(1) time
 *                    
 * All rights reserved.
 ******************************************************************************/
package datastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class HashTableO1Oper {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void insert(int data) {
        if (map.containsKey(data)) {
            return;
        }
        map.put(data, list.size());
        list.add(data);
    }

    public boolean contains(int data) {
        if (map.containsKey(data)) {
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get((int) Math.random() * (list.size() - 0));
    }

    public void remove(int data) {
        if (!map.containsKey(data)) {
            return;
        }
        int oldIdx = map.get(data);
        map.remove(data);
        list.set(oldIdx, list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), oldIdx);
        list.remove(list.size() - 1);
    }
}
