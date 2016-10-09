package XMLLiteParser;

import XMLLiteParser.Core.Node;
import XMLLiteParser.Core.Parser;
import XMLLiteParser.Core.TransitionSystem;
import XMLLiteParser.Gui.TreeView;
import XMLLiteParser.SchemaTools.SchemaInterpreter;

import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.util.Date;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        //TODO remove all todos before the end
        //TODO if we have time : verify class structure
        long startTime = System.currentTimeMillis();

        TransitionSystem ts = new TransitionSystem();
        Node rootNode = null;

        try {
            ts.parseFile("XMLDocs\\Ok.xmll");
            rootNode = Parser.getInstance().getRootNode();

            SchemaInterpreter schemaInterpreter = SchemaInterpreter.getInstance();
            schemaInterpreter.validateTree(rootNode, "XMLDocs\\QCM.dtd");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Document validated in " + (new Date().getTime() - startTime) + " ms");

        DefaultTreeModel tm = new DefaultTreeModel(rootNode);
        TreeView tv = new TreeView(tm);

        tv.setVisible(true);
        }
    }