package medallia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class FindCommonSubTree {
    private static class Node {
        private final int id;
        private final List<Node> children;

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    private static List<Node> getLargestCommonSubtrees(Node root) {
        // YOUR CODE HERE
        HashMap<String, ArrayList<Node>> map = new HashMap<String, ArrayList<Node>>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();
            String sig = getSignature(cur);
            if (map.containsKey(sig)) {
                ArrayList<Node> list = map.get(sig);
                list.add(cur);
                map.put(sig, list);
            } else {
                ArrayList<Node> list = new ArrayList<Node>();
                list.add(cur);
                map.put(sig, list);
            }
            for (int i = 0; i < cur.children.size(); i++) {
                if (cur.children.get(i) != null) {
                    queue.add(cur.children.get(i));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Node> ans = new ArrayList<Node>();
        for (Entry<String, ArrayList<Node>> e : map.entrySet()) {
            if (e.getKey().length() >= max) {
                if (e.getKey().length() > max) {
                    ans.clear();
                }
                ans.addAll(e.getValue());
            }
        }
        return ans;
    }

    private static String getSignature(Node n) {
        String signature = "";
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(n);
        if (n.children.size() == 0) {
            signature = "0";
            return signature;
        }
        Node curr = null;
        while (!q.isEmpty()) {
            curr = q.peek();
            q.poll();
            signature += String.valueOf(curr.children.size());
            for (int i = 0; i < curr.children.size(); i++) {
                q.offer(curr.children.get(i));
            }
        }
        return signature;
    }

    private void basicTest() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node3.children.add(node5);
        node3.children.add(node6);
        node4.children.add(node7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        node5.children.add(node8);
        node6.children.add(node9);
        node7.children.add(node10);
        node7.children.add(node11);

        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);

        node8.children.add(node12);
        node8.children.add(node13);
        node9.children.add(node14);
        node9.children.add(node15);
        node11.children.add(node16);

        Node node17 = new Node(17);
        Node node18 = new Node(18);
        node12.children.add(node17);
        node15.children.add(node18);

        List<Node> result = getLargestCommonSubtrees(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        FindCommonSubTree test = new FindCommonSubTree();
        test.basicTest();
    }
}
