package misc;

public class CheckBST {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    
    public static boolean solution(TreeNode root){
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean check(TreeNode root, int lwBnd, int upBnd){
        if(root == null){
            return false;
        }
        if(root.val < lwBnd || root.val >= upBnd){
            return false;
        }
        return check(root.left, lwBnd, root.val) && check(root.right, root.val, upBnd);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(6);
        a.left = b;
        a.right = c;
        c.left = d;
        System.out.println(CheckBST.solution(a));
    }
}
