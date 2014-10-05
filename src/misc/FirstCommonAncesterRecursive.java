package misc;

import util.BinaryTreeNode;

public class FirstCommonAncesterRecursive {

    public class Res {
        public BinaryTreeNode target = null;
    }

    public static int search(BinaryTreeNode root, BinaryTreeNode et1, BinaryTreeNode et2, Res ans) {
        if(root == null){
            return 0;
        }
        int lCount = search(root.left, et1, et2, ans), rCount = search(root.right, et1, et2, ans);
        if(lCount == 2 || rCount == 2){
            return 2;
        }
        int rootCnt = (root == et1 || root == et2) ? 1: 0;
        if(lCount + rootCnt + rCount == 2){
            ans.target = root;
        }
        return lCount + rootCnt + rCount;
    }
}
