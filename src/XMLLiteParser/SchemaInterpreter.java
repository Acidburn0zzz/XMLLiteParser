package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class SchemaInterpreter {
    private ArrayList<Constraint> constraints;

    public SchemaInterpreter() {
    }

    public void addConstraint(Constraint c){
        constraints.add(c);
    }
}
