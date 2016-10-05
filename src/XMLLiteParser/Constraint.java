package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Constraint {
    private String nom;
    private ArrayList<Child> children;

    /**
     *
     * @param nom nom de la balise à contraindre
     */
    public Constraint(String nom) {
        this.nom = nom;
    }

    public void addChildren(Child c){
        children.add(c);
    }

    public String getNom() {
        return nom;
    }

    public int getChildCount(){
        return children.size();
    }

}
