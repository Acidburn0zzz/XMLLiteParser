import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by MrMan on 12/09/2016.
 */
public class XMLLiteNode implements TreeNode, Iterable<Integer> {
    private String name;
    private String content;
    private XMLLiteNode parent;
    private ArrayList<XMLLiteNode> children;
    
    public XMLLiteNode(String name) {
        this.name = name;
        this.parent = null;
        children = new ArrayList<>();
    }

    public XMLLiteNode(String name, XMLLiteNode parent) {
        this.name = name;
        this.parent = parent;
        children = new ArrayList<>();
        parent.addChildren(this);
    }

    public void fillContent(String content){
        this.content = content;
    }

    public void addChildren(XMLLiteNode node){
        children.add(node);
    }

    public String getName() {
        return name;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return (TreeNode)children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    public TreeNode getParent() {
        return (TreeNode)parent;
    }

    //TreeNode Interface
    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(this);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        if(children.isEmpty()) {
            System.out.println("true");
            System.out.println(parent.toString());
        }
        else
            System.out.println("false");

        return children.isEmpty();

    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(children);
    }

    //Iterable Interface

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return children.size() > cursor;
            }

            @Override
            public Integer next() {
                if(this.hasNext()){
                    int current = cursor;
                    cursor++;
                    return current;
                }
                throw new NoSuchElementException();
            }
        };
    }

    @Override
    public String toString() {
        return getName();
    }
}
