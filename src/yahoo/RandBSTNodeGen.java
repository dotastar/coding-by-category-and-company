/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RandBSTNodeGen.java
 *         Version:   1.0
 *         Created:   6/8 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class RandBSTNodeGen {
    
    public static class Node{
        public int val;
        public Node left;
         public Node right;
public         int leftNum;
        
        public Node(int val){
           this.val = val;
        }
    }

    public Node generate(Node root, int k){
           if(k <= root.leftNum){
                return generate(root.left, k);
           }else if(k == root.leftNum + 1){
                return root;
           }else{
                return generate(root.right, k - (root.leftNum + 1));
           }
    }

    public void insert(Node root, Int val){
          if(val <= root.val){
               root.leftNum++;
               if(root.left != null){
                   insert(root.left, val);
               }else{
                   root.left = new Node(val);
               }
          }else{
              if(root.right != null){
                  insert(root.right, val);
              }else{
                  root.right = new Node(val);
              }
          }
    }
   

public Node{
   int val;
   Node left;
   Node right;
   
   public Node(int val){
       this.val = val;
   }
}

public Struct{
    public Node root;
    public int idx;
    
    public struct(int root, int idx){
          root = new Node(root);
          this.idx = idx;
    }
    
}

public Struct constructRec(int[] input, int idx, int key, int min, int max, int size){
   Struct root = null;
   if(key > min && key < max){
       root = new Struct(key, idx);
       idx++;
       if(idx < size){
            Struct left = constructRec(input, idx, input[idx], min, root.val, size);
            root.left = left.root;
            root.idx = left.idx;
        }
       if(idx < size){
            Struct right = constructRec(intput, root.idx, input[idx], root.val, max, size);
            root.right = right.root;
            root.idx = right.idx;
        }
   }
   return root;
}

public Node construct(int[] input){
   return constructRec(input, input[0], 0, Integer.MIN_VALUE, Integer.MAX_VALUE, input.length);
}

}
