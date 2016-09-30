import java.io.IOException;
import java.util.Date;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        TransitionSystem ts = new TransitionSystem();
        try {
            long startTime = System.currentTimeMillis();
            long elapsedTime;

            ts.parseFile("XMLDocs\\Ok.xmll");
            XMLLiteNode node = XMLLiteParser.getInstance().getRootNode();
            elapsedTime = (new Date()).getTime() - startTime;
            System.out.println("Document parsed in " + (elapsedTime) + " ms");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}