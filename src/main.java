import java.io.IOException;
import java.util.Date;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        TransitionSystem ts = new TransitionSystem();
        try {
            ts.openXMLFile("XMLDocs\\Success.xmll");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        ts.start();
        elapsedTime = (new Date()).getTime() - startTime;
        System.out.println("Document validated in " + (elapsedTime) + " ms");
        TreeView tv = new TreeView();
        tv.setVisible(true);
        }
    }
}