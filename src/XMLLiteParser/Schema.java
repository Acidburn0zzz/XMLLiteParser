package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Schema {
    private ArrayList<Constraint> constraints = new ArrayList<>();

    public void addConstraint(Constraint c){
        constraints.add(c);
    }

    public Constraint getConstraint(String name){
        for (Constraint c : constraints) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
