import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    }

    public XMLLiteNode(String name, XMLLiteNode parent) {
        this.name = name;
        this.parent = parent;
        parent.addChildren(this);
    }

    public void fillContent(String content){
        this.content = content;
    }

    public void addChildren(XMLLiteNode node){
        if(children == null)
            children = new ArrayList<>();
        children.add(node);
    }

    public String getName() {
        return name;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    public XMLLiteNode getParent() {
        return parent;
    }

    //TreeNode Interface
    @Override
    public int getIndex(TreeNode node) {
        return parent.children.indexOf(this);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return children.size()!=0;
    }

    @Override
    public Enumeration children() {
        return (Enumeration) this;
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
}
