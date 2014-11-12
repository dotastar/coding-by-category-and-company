package util;

public class DLLNode {
    public int data;
    public DLLNode prev;
    public DLLNode next;
    public DLLNode(int data){
        this.data = data;
        this.prev = this.next = null;
    }
}
