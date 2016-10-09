package XMLLiteParser.SchemaTools;

import XMLLiteParser.Core.Node;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by MrMan on 05/10/2016.
 */
public class SchemaValidator {
    private Schema schema;

    public SchemaValidator(Schema schema) {
        this.schema = schema;
    }

    public boolean isValid(Node rootNode) {
        boolean res = true;
        Constraint c = schema.getConstraint(rootNode.getName());

        if (c != null) {
            ArrayList<Child> requiredChildren = c.getRequiredChildren();
            ArrayList<Child> children = c.getChildrenCopy();
            Enumeration nodeEnum = rootNode.children();

            while (nodeEnum.hasMoreElements()) {
                Node node = (Node) nodeEnum.nextElement();
                boolean found = false;
                Child toRemove = null;
                for (Child child : children) {
                    if (child.getName().equals(node.getName())) {
                        if (requiredChildren.contains(child)) {
                            requiredChildren.remove(child);
                        }
                        toRemove = child;
                        found = true;
                        break;
                    }
                }
                if(found)
                    children.remove(toRemove);
                else{
                    res = false;
                }
            }
            if (!requiredChildren.isEmpty()) {
                res = false;
            }
        }

        if (res){
            Enumeration enumeration = rootNode.children();
            while (enumeration.hasMoreElements() && res){
                Node node = (Node) rootNode;
                res =  isValid((Node) enumeration.nextElement());
            }
        }
        return res;
    }


}
