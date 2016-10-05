package XMLLiteParser;

import XMLLiteParser.Gui.TreeView;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.io.IOException;
import java.util.Date;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        TransitionSystem ts = new TransitionSystem();
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        try {
            ts.parseFile("XMLDocs\\Ok.xmll");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Node rootNode = Parser.getInstance().getRootNode();

        Schema schema = new Schema();
        Constraint constraint = new Constraint("CD");
        constraint.addChild(new Child("TITLE", true));
        constraint.addChild(new Child("ARTIST", true));
        constraint.addChild(new Child("COUNTRY", true));
        constraint.addChild(new Child("COMPANY", true));
        constraint.addChild(new Child("PRICE", true));
        constraint.addChild(new Child("YEAR", true));

        schema.addConstraint(constraint);

        SchemaValidator schemaValidator = new SchemaValidator(schema);
        System.out.println(schemaValidator.isValid(rootNode));

        elapsedTime = (new Date()).getTime() - startTime;
        System.out.println("Document validated in " + (elapsedTime) + " ms");

        DefaultTreeModel tm = new DefaultTreeModel(rootNode);
        TreeView tv = new TreeView(tm);

        tv.setVisible(true);
        }
    }