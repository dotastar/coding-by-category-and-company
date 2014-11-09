package util;

import java.util.ArrayList;

public class GraphNode {
    public int label;
    public int weight;
    public ArrayList<GraphNode> neighbors;

    public GraphNode(int x) {
        label = x;
        neighbors = new ArrayList<GraphNode>();
    }
}
