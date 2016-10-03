/**
 * Created by MrMan on 12/09/2016.
 */
public class XMLLiteParser {
    private static XMLLiteParser instance;
    private String buffer;
    private XMLLiteNode lastNode;
    private boolean nodeBeforeContent; //Because there can be content only before new nodes
    private XMLLiteNode rootNode;
    private boolean rootNodeClosed = false;

    private XMLLiteParser() {
        buffer = "";
        nodeBeforeContent = false;
    }

    public static XMLLiteParser getInstance() {
        if (instance == null)
            instance = new XMLLiteParser();
        return instance;
    }

    public void fillBuffer(char c){
        buffer += c;
    }

    public void createNode() throws EmptyNameException{
        if(buffer.isEmpty())
            throw new EmptyNameException();

        XMLLiteNode node;

        if(lastNode == null) {
            node = new XMLLiteNode(buffer);
            rootNode = node;
        }else{
            node = new XMLLiteNode(buffer, lastNode);
        }

        lastNode = node;
        buffer = "";
        nodeBeforeContent = false;
    }

    public void closeNode() throws UnexpectedClosingNameException{
        if(lastNode!=null) {
            if (buffer.compareTo(lastNode.toString()) != 0) {
                throw new UnexpectedClosingNameException("\"" + buffer + "\"" + " found should be : " + "\"" + lastNode.toString() + "\"");
            }
        }else
            System.err.println("Not intended null lastnode");
        if (lastNode != rootNode) {
            lastNode = (XMLLiteNode) lastNode.getParent();
        }else{
            rootNodeClosed = true;
        }
        buffer = "";
        nodeBeforeContent = true;
    }

    public void fillNodeContent() throws NodeBeforeContentException{
        assert(!buffer.isEmpty());
        if(nodeBeforeContent)
            throw new NodeBeforeContentException();

        lastNode.fillContent(buffer);
        buffer = "";
    }

    public XMLLiteNode getRootNode() {
        return rootNode;
    }

    public boolean isRootNodeClosed(){
        return rootNodeClosed;
    }

    public XMLLiteNode getLastNode() {
        return lastNode;
    }
}
