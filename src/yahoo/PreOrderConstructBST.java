package yahoo;

public class PreOrderConstructBST {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int idx = 0;

    public Node constructRec(int[] input, int key, int min, int max) {
        Node root = null;
        if (idx >= input.length) {
            return root;
        }
        if (key > min && key < max) {
            root = new Node(key);
            idx++;
            root.left = constructRec(input, input[idx], min, root.val);
            root.right = constructRec(input, input[idx], root.val, max);
        }
        return root;
    }

    public Node construct(int[] input) {
        return constructRec(input, input[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
