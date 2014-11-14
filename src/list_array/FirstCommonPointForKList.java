/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FirstCommonPointForKList.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find the first common point for k-lists 
 *                    
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.ArrayList;
import java.util.HashMap;

import util.ListNode;

public class FirstCommonPointForKList {
    public ListNode searchCommonPoint(ArrayList<ListNode> klists){
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        int k = 0;
        while(klists.get(k) != null){
            if(!map.containsKey(klists.get(k))){
                map.put(klists.get(k), map.get(klists.get(k)) + 1);
            }else{
                map.put(klists.get(k), 1);
            }
            if(map.get(klists.get(k)) == klists.size()){
                return klists.get(k);
            }
            klists.set(k, klists.get(k).next);
            k = (k + 1) % klists.size();
        }
        return null;
    }
}
