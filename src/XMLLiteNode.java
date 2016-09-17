import java.util.ArrayList;

/**
 * Created by MrMan on 12/09/2016.
 */
public class XMLLiteNode {
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

    public XMLLiteNode getParent() {
        return parent;
    }
}
