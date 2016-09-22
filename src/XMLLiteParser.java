/**
 * Created by MrMan on 12/09/2016.
 */
public class XMLLiteParser {
    private static XMLLiteParser instance;
    private String buffer;
    private XMLLiteNode lastNode;
    private boolean nodeBeforeContent; //Because there can be content only before new nodes
    private XMLLiteNode rootNode;

    private XMLLiteParser() {
        buffer = null;
        lastNode = null;
        nodeBeforeContent = false;
    }

    public static XMLLiteParser getInstance(){
        if(instance==null)
            instance = new XMLLiteParser();
        return instance;
    }
    public void fillBuffer(char c){
        buffer += c;
    }

    public void createNode(){
        assert (!buffer.isEmpty());
        XMLLiteNode node;

        if(lastNode != null) {
            node = new XMLLiteNode(buffer, lastNode);
            rootNode = node;
            lastNode.addChildren(node);
        }else{
            node = new XMLLiteNode(buffer);
        }

        lastNode = node;
        buffer = null;
        nodeBeforeContent = false;
    }

    public void closeNode(){
        assert(buffer == lastNode.getName());

        lastNode = lastNode.getParent();
        buffer = null;
        nodeBeforeContent = true;
    }

    public void fillNodeContent(){
        assert(!(buffer.isEmpty() && nodeBeforeContent));

        lastNode.fillContent(buffer);
        buffer = null;
    }

    public XMLLiteNode getRootNode() {
        return rootNode;
    }
}
