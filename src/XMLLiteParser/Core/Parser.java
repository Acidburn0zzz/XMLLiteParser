package XMLLiteParser.Core;

import XMLLiteParser.Exception.EmptyNameException;
import XMLLiteParser.Exception.NodeBeforeContentException;
import XMLLiteParser.Exception.UnexpectedClosingNameException;

/**
 * Created by MrMan on 12/09/2016.
 */
public class Parser {
    private static Parser instance;
    private String buffer;
    private Node lastNode;
    private Node rootNode;
    private boolean nodeBeforeContent;
    private boolean rootNodeClosed = false;

    private Parser() {
        buffer = "";
        nodeBeforeContent = false;
    }

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();
        return instance;
    }

    public void createNode() throws EmptyNameException {
        if(buffer.isEmpty())
            throw new EmptyNameException();

        Node node;

        if(lastNode == null) {
            node = new Node(buffer);
            rootNode = node;
        } else {
            node = new Node(buffer, lastNode);
        }

        lastNode = node;
        buffer = "";
        nodeBeforeContent = false;
    }

    public void closeNode() throws UnexpectedClosingNameException {
        if(lastNode!=null) {
            if (buffer.compareTo(lastNode.getName()) != 0)
                throw new UnexpectedClosingNameException("\"" + buffer + "\"" + " found should be : " + "\"" + lastNode.getName() + "\"");
        }else
            System.err.println("Not intended null lastnode");


        if (lastNode != rootNode)
            lastNode = (Node) lastNode.getParent();
        else
            rootNodeClosed = true;

        buffer = "";
        nodeBeforeContent = true;
    }

    public void fillNodeContent() throws NodeBeforeContentException {
        assert(!buffer.isEmpty());
        if(nodeBeforeContent)
            throw new NodeBeforeContentException();

        lastNode.setContent(buffer);
        buffer = "";
    }

    public void fillBuffer(char c){ buffer += c; }

    //region Getters and Setters
    public Node getRootNode() { return rootNode; }

    public boolean isRootNodeClosed(){ return rootNodeClosed; }
    //endregion

}
