package util;

import java.util.ArrayList;

public class Graph {
    public int V;
    public int E;
    public ArrayList<Edge> edges;

    public Graph(int V, int E, ArrayList<Edge> edges) {
        this.V = V;
        this.E = E;
        this.edges = new ArrayList<Edge>(edges);
    }
}
