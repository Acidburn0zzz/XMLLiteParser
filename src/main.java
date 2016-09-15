import java.io.IOException;

/**
 * Created by MrMan on 12/09/2016.
 */
public class main {
    public static void main(String[] args) {
        TransitionSystem ts = new TransitionSystem();
        try {
            ts.openXMLFile("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ts.start();
        System.out.println("Wow");
    }
}