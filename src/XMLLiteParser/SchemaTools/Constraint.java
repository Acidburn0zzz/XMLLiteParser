package XMLLiteParser.SchemaTools;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Constraint {
    private String name;
    private ArrayList<Child> children = new ArrayList<>();

    /**
     * @param nom name de la balise à contraindre
     */
    public Constraint(String nom) {
        this.name = nom;
    }

    //region Getters and setters
    public void addChild(Child c){ children.add(c); }

    public String getName() { return name; }

    public int getChildCount(){ return children.size(); }

    /**
     * @param name name de l'enfant à rechercher
     * @return l'enfant qui a pour name le paramètre name.
     * Si il y a plusieurs enfant avec le même name, la méthode renvoie le premier.
     */
    public Child getChild(String name){
        Child res = null;
        for (Child c: children) {
            if (c.getName().equals(name)){
                res = c;
                break; // on quitte la boucle dès qu'on trouve un enfant.
            }
        }
        return res;
    }

    /**
     * @return Liste de tout les enfants oblogatoires, si il n'y en a pas, la liste est juste vide.
     */
    public ArrayList<Child> getRequiredChildren(){
        return children.stream().filter(Child::isRequired).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Child> getChildrenCopy() { return new ArrayList<>(children); }
    //endregion
}
