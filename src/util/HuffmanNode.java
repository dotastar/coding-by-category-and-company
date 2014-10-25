package util;

public class HuffmanNode {
    public char data;
    public int freq;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

}
