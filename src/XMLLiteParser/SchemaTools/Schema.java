package XMLLiteParser.SchemaTools;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Schema {
    private ArrayList<Constraint> constraints = new ArrayList<>();

    //region Getters and setters
    public void addConstraint(Constraint c){ constraints.add(c); }

    /**
     * @param name
     * @return null if no constraint correspond to the given name
     */
    public Constraint getConstraint(String name){
        for (Constraint c : constraints) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    //endregion
}
