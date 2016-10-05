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
        try {
            ts.parseFile("XMLDocs\\success.xmll");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        elapsedTime = (new Date()).getTime() - startTime;
        System.out.println("Document validated in " + (elapsedTime) + " ms");

        DefaultTreeModel tm = new DefaultTreeModel((TreeNode)XMLLiteParser.getInstance().getRootNode());
        TreeView tv = new TreeView(tm);

        tv.setVisible(true);
        }
    }