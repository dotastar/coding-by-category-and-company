package util;

public class IntervalNode {
    public int start;
    public int end;
    public IntervalNode left;
    public IntervalNode right;
    public IntervalNode(Interval o){
        this.start = o.start;
        this.end = o.end;
    }
}
