package util;

import java.util.ArrayList;

public class GraphNode {
    public int label;
    public int weight;
    public ArrayList<GraphNode> adjs;

    public GraphNode(int x) {
        label = x;
        adjs = new ArrayList<GraphNode>();
    }
}
