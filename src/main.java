import java.io.IOException;
import java.util.Date;
import java.util.Timer;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        TransitionSystem ts = new TransitionSystem();
        try {
            ts.openXMLFile("XMLDocs\\ok.xmll");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        ts.start();
        elapsedTime = (new Date()).getTime() - startTime;
        System.out.println("Document validated in " + (elapsedTime) + " ms");
        System.out.println(XMLLiteParser.getInstance().getRootNode().getName());
        TreeView tv = new TreeView();
        tv.setVisible(true);
    }
}