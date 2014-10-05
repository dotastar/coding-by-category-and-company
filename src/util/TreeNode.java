package util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public final int id;
    public final List<TreeNode> children;

    public TreeNode(int id) {
        this.id = id;
        this.children = new ArrayList<TreeNode>();
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
