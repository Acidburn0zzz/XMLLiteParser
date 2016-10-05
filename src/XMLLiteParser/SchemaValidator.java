package XMLLiteParser;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by MrMan on 05/10/2016.
 */
public class SchemaValidator {
    private ArrayList<Node> constraintNodes;

    public boolean respectSchema(Node node, ArrayList<Constraint> constraints){
        boolean res = true;
        for (Constraint c : constraints) {
            if (c.getName().equals(node.toString())){
                ArrayList<Child> requiredChildren = c.getRequiredChildren();
                Enumeration<Node> nodeEnum = node.children();
                while (nodeEnum.hasMoreElements()){
                    Child child = c.getChild(((Node)nodeEnum.nextElement()).toString());
                    if (child != null){
                        if (requiredChildren.contains(child)){
                            requiredChildren.remove(child);
                        }
                    }else{
                        res = false;
                    }
                }
                if (requiredChildren.size() != 0){
                    res = false;
                }
                break;
            }
        }
        if (node.getChildCount() != 0 && res != false){
            while (node.children().hasMoreElements()){
                respectSchema((Node)node.children().nextElement(), constraints);
            }
        }
        return res;
    }


}
