package medallia;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Reverse {
    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    static LinkedListNode reverse(LinkedListNode list, int k) {
        Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
        int listLen = getLen(list);
        int firstBlockLen = listLen % k;
        LinkedListNode start = list, end = list;
        if(firstBlockLen != 0) {
            int count = 1;
            while (count < firstBlockLen) {
                end = end.next;
                count++;
            }
            LinkedListNode temp = end.next;
            end.next = null;
            end = temp;
            stack.push(start);
            start = end;
        }
        int numBlock = (listLen) / k;
        for (int i = 0; i < numBlock; i++) {
            int count = 1;
            while (count < k) {
                end = end.next;
                count++;
            }
            LinkedListNode temp = end.next;
            end.next = null;
            end = temp;
            stack.push(start);
            start = end;
        }
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode cur = dummy;
        while (!stack.empty()) {
            cur.next = stack.peek();
            cur = stack.pop();
            while (cur.next != null) {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    static int getLen(LinkedListNode list) {
        LinkedListNode iter = list;
        int len = 0;
        while (iter != null) {
            len++;
            iter = iter.next;
        }
        return len;
    }

    /** @return {@link LinkedListNode} head of the linked list containing the given values */
    static LinkedListNode createFromList(List<Integer> list) {
        LinkedListNode head = null;
        LinkedListNode node = null;
        for (int val : list) {
            LinkedListNode prev = node;
            node = new LinkedListNode(val);
            if (head == null)
                head = node;

            if (prev != null)
                prev.next = node;
        }

        return head;
    }

    /** Asserts that two linked lists are equal */
    static void assertLinkedListsEqual(LinkedListNode root1, LinkedListNode root2) {
        LinkedListNode node1 = root1;
        LinkedListNode node2 = root2;
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val)
                throw new AssertionError("Expected " + printLinkedList(root1) + " but found " + printLinkedList(root2));
            node1 = node1.next;
            node2 = node2.next;
        }

        if (node1 == null ^ node2 == null)
            throw new AssertionError("Expected " + printLinkedList(root1) + " but found " + printLinkedList(root2));
    }

    /** Prints the linked lists */
    static String printLinkedList(LinkedListNode head) {
        StringBuilder sb = new StringBuilder();
        LinkedListNode node = head;
        while (node != null) {
            if (node != head)
                sb.append(',');
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }

    private static void basicTest() {
        LinkedListNode testLinkedList = createFromList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        LinkedListNode reversed = reverse(testLinkedList, 2);
        LinkedListNode expected = createFromList(Arrays.asList(8, 9, 6, 7, 4, 5, 2, 3, 1));
        assertLinkedListsEqual(expected, reversed);
    }
    
    public static void main(String[] args) {
        LinkedListNode testLinkedList = createFromList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(printLinkedList(testLinkedList));
        LinkedListNode reversed = reverse(testLinkedList, 4);
        System.out.println(printLinkedList(reversed));
    }
}
