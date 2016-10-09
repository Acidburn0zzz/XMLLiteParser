package XMLLiteParser.SchemaTools;


import XMLLiteParser.Exception.EmptyNameException;

/**
 * Created by MrMan on 09/10/2016.
 */
public class DTDParser {
    private static DTDParser instance;
    private String buffer = "";
    private Constraint currentConstraint;
    private Child lastChild;
    private Schema schema = new Schema();

    private DTDParser() {
    }

    public static DTDParser getInstance(){
        if(instance == null)
            instance = new DTDParser();
        return instance;
    }

    public void createConstraint() throws EmptyNameException {
        if(buffer.isEmpty())
            throw new EmptyNameException();

        System.out.println("Create constraint : " + buffer);
        currentConstraint = new Constraint(buffer);

        buffer = "";
    }

    public void closeConstraint(){
        schema.addConstraint(currentConstraint);
    }

    public void addChild(){
        if(buffer != "") {
            System.out.println("Create child " + buffer);
            lastChild = new Child(buffer, false);
            currentConstraint.addChild(lastChild);
            buffer = "";
        }
    }

    public void setLastChildRequired(){
        lastChild.setRequired(true);
    }

    public Schema getSchema(){
        return schema;
    }

    public void fillBuffer(char c) {
        buffer += c;
    }
}
