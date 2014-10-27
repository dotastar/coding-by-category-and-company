/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   HuffmanCoding.java
 *         Created:   Oct 23, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given a set of chars {a1, a2, a3, a4....}, and a set of their frequencies {c1, c2, ....}
 *                    How to encode this set chars to a set of binary codes {l1, l2, l3, ....}
 *                    So that we can get Min(l1*c1 + l2*c2 + ......)
 *                    Time Complexity is O(nlogn)
 * All rights reserved.
 ******************************************************************************/
package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.HuffmanNode;

public class HuffmanCoding {
    public HuffmanNode buildHuffmanTree(char[] data, int[] freqs, int size){
        PriorityQueue<HuffmanNode> heap = new PriorityQueue<HuffmanNode>(1, new Comparator<HuffmanNode>(){
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.freq - o2.freq;
            }
        });
        for(int i = 0; i < size; i++){
            heap.add(new HuffmanNode(data[i], freqs[i]));
        }
        while(heap.size() != 1){
            HuffmanNode left = heap.poll(), right = heap.poll();
            HuffmanNode top = new HuffmanNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heap.add(top);
        }
        return heap.poll();
    }
    
    public void printCodes(HuffmanNode root, StringBuilder sb){
        if(root.left != null){
            sb.append('0');
            printCodes(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(root.right != null){
            sb.append('1');
            printCodes(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(root.left == null && root.right == null){
            System.out.println(root.data + " " + sb.toString());
        }
    }
    
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        int freq[] = {5, 9, 12, 13, 16, 45};
        HuffmanCoding test = new HuffmanCoding();
        test.printCodes(test.buildHuffmanTree(arr, freq, arr.length), new StringBuilder());
    }
}
