package util;

public class Edge implements Comparable<Edge>{
    public int src;
    public int dec;
    public int weight;

    public Edge(int et1, int et2, int et3) {
        this.src = et1;
        this.dec = et2;
        this.weight = et3;
    }

    @Override
    public String toString() {
        return src + "" + dec;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
