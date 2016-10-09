package XMLLiteParser.SchemaTools;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Constraint {
    //TODO translate in english
    private String nom;
    private ArrayList<Child> children = new ArrayList<>();

    /**
     * @param nom nom de la balise à contraindre
     */
    public Constraint(String nom) {
        this.nom = nom;
    }

    //region Getters and setters
    public void addChild(Child c){ children.add(c); }

    public String getName() { return nom; }

    public int getChildCount(){ return children.size(); }

    /**
     * @param name nom de l'enfant à rechercher
     * @return l'enfant qui a pour nom le paramètre name.
     * Si il y a plusieurs enfant avec le même nom, la méthode renvoie le premier.
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
