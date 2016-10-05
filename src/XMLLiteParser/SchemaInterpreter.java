package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class SchemaInterpreter {
    private ArrayList<Constraint> constraints;
    private SchemaInterpreter sh;

    private SchemaInterpreter() {
    }

    public SchemaInterpreter getInstance(){
        if(sh == null){
            sh = new SchemaInterpreter();
        }
        return sh;
    }

    public void addConstraint(Constraint c){
        constraints.add(c);
    }

    public Constraint getConstraint(String name){
        Constraint res = null;
        for (Constraint c: constraints) {
            if (c.getName().equals(name)){
                res = c;
                break;
            }
        }
        return res;
    }
}
