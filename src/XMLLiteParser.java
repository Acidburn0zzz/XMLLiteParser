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
        buffer = "";
        lastNode = null;
        nodeBeforeContent = false;
    }

    public static XMLLiteParser getInstance(){
        if(instance == null)
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
            lastNode = node;
            // lastNode.addChildren(node); À faire par le constructeur à deux paramètres de la classe node.
        }else{
            node = new XMLLiteNode(buffer);
            rootNode = node;
        }

        lastNode = node;
        buffer ="";
        nodeBeforeContent = false;
    }

    public void closeNode(){
        assert(buffer == lastNode.getName());

        lastNode = (XMLLiteNode)lastNode.getParent();
        buffer = "";
        nodeBeforeContent = true;
    }

    public void fillNodeContent(){
        assert(!(buffer.isEmpty() && nodeBeforeContent));

        lastNode.fillContent(buffer);
        buffer = "";
    }

    public XMLLiteNode getRootNode() {
        return rootNode;
    }
}
