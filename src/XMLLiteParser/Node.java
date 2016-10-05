package XMLLiteParser;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by MrMan on 12/09/2016.
 */
public class Node implements TreeNode {
    private String name;
    private String content;
    private Node parent;
    private ArrayList<Node> children;
    
    public Node(String name) {
        this.name = name;
        this.parent = null;
        children = new ArrayList<>();
    }

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
        children = new ArrayList<>();
        parent.addChildren(this);
    }

    public void fillContent(String content){
        this.content = content;
    }

    public void addChildren(Node node){
        children.add(node);
    }

    @Override public String toString() { return name; }

    //TreeNode Interface

    @Override public TreeNode getChildAt(int childIndex) { return children.get(childIndex); }

    @Override public int getChildCount() { return children.size(); }

    @Override public TreeNode getParent() { return parent; }

    @Override public int getIndex(TreeNode node) { return children.indexOf(this); }

    @Override public boolean getAllowsChildren() { return true; }

    @Override public boolean isLeaf() { return children.isEmpty(); }

    @Override public Enumeration children() { return Collections.enumeration(children); }

}
