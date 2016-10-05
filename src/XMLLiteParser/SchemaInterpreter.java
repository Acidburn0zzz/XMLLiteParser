package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class SchemaInterpreter {
    private ArrayList<Constraint> constraints;
    private static SchemaInterpreter sh;

    private SchemaInterpreter() {}

    public static SchemaInterpreter getInstance(){
        if(sh == null){
            sh = new SchemaInterpreter();
        }
        return sh;
    }


}
