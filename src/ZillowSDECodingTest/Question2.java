package ZillowSDECodingTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

/**
 * @author Nan Zhang
 */
public class Question2 {

    /**
     * this Node.class is data structure for tri-nary tree
     */
    public static class Node {
        Node left;
        Node right;
        Node middle;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.middle = null;
        }
    }

    /**
     * implement how to insert node to tri-nary tree, and return the root node
     * @param root
     * @param value
     * @return
     */
    public static Node insert(Node root, int value) {
        if (root == null)
            return null;
        if (value < root.value) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new Node(value);
            }
        } else if (value == root.value) {
            if (root.middle != null) {
                insert(root.middle, value);
            } else {
                root.middle = new Node(value);
            }
        } else {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new Node(value);
            }
        }
        return root;
    }

    /**
     * implement how to remove a node from tri-nary tree, if don't find, print the log!
     * @param root
     * @param value
     * @return
     * @throws IOException
     */
    public static Node remove(Node root, int value) throws IOException {
        if (root == null) {
            System.out.println("can't find the element to be removed!");
            return null;
        }
        if (value == root.value) {
            if (root.middle != null) {
                root.middle.left = root.left;
                root.middle.right = root.right;
                return root.middle;
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    return adjust(root.right, root.left, root.right);
                }
            }
        } else if (value < root.value) {
            root.left = remove(root.left, value);
        } else {
            root.right = remove(root.right, value);
        }
        return root;
    }

    /**
     * get left-most node of right child tree; put it to new root, and update its parent
     * @param start
     * @param oldRootLeft
     * @param oldRootRight
     * @return
     */
    public static Node adjust(Node start, Node oldRootLeft, Node oldRootRight) {
        if (start.left == null) {
            start.left = oldRootLeft;
            return start;
        }
        Node leftMost = start.left;
        Node leftMostParent = start;
        while (leftMost.left != null) {
            leftMostParent = leftMost;
            leftMost = leftMost.left;
        }
        leftMostParent.left = leftMost.right;
        leftMost.left = oldRootLeft;
        leftMost.right = oldRootRight;
        return leftMost;
    }

    /**
     * utility function for testing (just print the tree with Inorder)!
     * @param root
     */
    public static void traverseInOrder(Node root, ArrayList<String> treeContainer) {
        if (root == null) {
            treeContainer.add("null");
            return;
        }
        traverseInOrder(root.left, treeContainer);
        Node middleIter = root;
        while (middleIter != null) {
            treeContainer.add(String.valueOf(middleIter.value));
            middleIter = middleIter.middle;
        }
        treeContainer.add("null");
        traverseInOrder(root.right, treeContainer);
    }

    /**
     * test for for tri-nary tree
     * @return
     * @throws IOException
     */
    public static void test() throws IOException {
        //begin test insertion
        int[] testData = new int[] { 5, 4, 9, 5, 7, 2, 2 };
        Node root = new Node(testData[0]);
        for (int i = 1; i < testData.length; i++) {
            Question2.insert(root, testData[i]);
        }
        List<String> expected1 = Arrays.asList("null", "2", "2", "null", "null", "4", "null", "null", "5", "5", "null",
                "null", "7", "null", "null", "9", "null", "null");
        ArrayList<String> test1 = new ArrayList<String>();
        traverseInOrder(root, test1);
        Assert.assertEquals(expected1, test1);
        //begin test deletion     
        Node newRoot1 = remove(root, 5);
        Node newRoot2 = remove(newRoot1, 5);
        List<String> expected2 = Arrays.asList("null", "2", "2", "null", "null", "4", "null", "null", "7", "null",
                "null", "9", "null", "null");
        ArrayList<String> test2 = new ArrayList<String>();
        traverseInOrder(newRoot2, test2);
        Assert.assertEquals(expected2, test2);
    }

    public static void main(String[] args) throws IOException {
        test();
        System.out.println("test complete!");
    }
}
