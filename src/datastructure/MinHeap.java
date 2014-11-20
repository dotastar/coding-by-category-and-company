/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Heap.java
 *         Created:   Sep 21, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Use ArrayList to implement Min Heap
 *                    
 * All rights reserved.
 ******************************************************************************/
package datastructure;

import java.io.IOException;
import java.util.ArrayList;

public class MinHeap {

    public ArrayList<Integer> heap;

    public MinHeap(ArrayList<Integer> data) {
        heap = new ArrayList<Integer>();
        heap.add(null);//placeholder, think why? 0->2*0, 2*0 + 1
        heap.addAll(data);
    }

    public void buildHeap() {
        for (int i = heap.size() / 2; i >= 1; i--) {//NOTE
            reConstruct(i, heap.size());
        }
    }

    public int popMin() throws IOException {
        if (getSize() == 0) {
            throw new IOException("heap is empty.");
        }
        int lastIdx = heap.size() - 1, minVal = heap.get(1);
        heap.set(1, heap.get(lastIdx));
        heap.remove(lastIdx);
        reConstruct(1, heap.size());
        return minVal;
    }

    public int getSize() {
        return heap.size() - 1;
    }

    private void reConstruct(int i, int n) {
        int left = 2 * i, right = 2 * i + 1;
        while (left < heap.size()) {
            int childMin = left;
            if ((right < heap.size()) && (heap.get(right) < heap.get(left))) {
                childMin = right;
            }
            if (heap.get(i) > heap.get(childMin)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(childMin));
                heap.set(childMin, tmp);
                i = childMin;
                left = 2 * i;
                right = 2 * i + 1;
            } else {
                break;//NOTE that's why we build heap in bottom-up way!
            }
        }
    }

}
