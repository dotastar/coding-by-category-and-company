package util;

import java.util.ArrayList;

public class EdgeGraph {
    public int V;
    public int E;
    public ArrayList<Edge> edges;

    public EdgeGraph(int V, int E, ArrayList<Edge> edges) {
        this.V = V;
        this.E = E;
        this.edges = new ArrayList<Edge>(edges);
    }
}
