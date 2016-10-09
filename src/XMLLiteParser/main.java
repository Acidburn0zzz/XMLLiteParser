package XMLLiteParser;

import XMLLiteParser.Core.Node;
import XMLLiteParser.Core.Parser;
import XMLLiteParser.Core.TransitionSystem;
import XMLLiteParser.Gui.TreeView;
import XMLLiteParser.QCM.QCM;
import XMLLiteParser.QCM.QCMInterpreter;
import XMLLiteParser.SchemaTools.SchemaInterpreter;

import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            ts.parseFile("XMLDocs\\QCM.xmll");
            rootNode = Parser.getInstance().getRootNode();

            QCMInterpreter qcmInterpreter = new QCMInterpreter();
            QCM qcm = qcmInterpreter.interpreteTree(rootNode);
            System.out.println("WOW");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("Document validated in " + (new Date().getTime() - startTime) + " ms");


        DefaultTreeModel tm = new DefaultTreeModel(rootNode);
        TreeView tv = new TreeView(tm);

        tv.setVisible(true);
        }
    }