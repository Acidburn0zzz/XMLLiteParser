package XMLLiteParser;

import java.util.ArrayList;

/**
 * Created by Antoine on 05/10/2016.
 */
public class Constraint {
    private String nom;
    private ArrayList<Child> children;

    /**
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
        ArrayList<Child> res = new ArrayList<>();
        for (Child c: children) {
            if (c.isRequired()){
                res.add(c);
            }
        }
        return res;
    }
}
