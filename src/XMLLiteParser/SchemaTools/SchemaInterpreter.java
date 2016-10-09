package XMLLiteParser.SchemaTools;

import XMLLiteParser.Exception.InvalidDocumentException;
import XMLLiteParser.Core.Node;

import java.io.IOException;

/**
 * Created by Antoine on 05/10/2016.
 */
public class SchemaInterpreter {
    private static SchemaInterpreter schemaInterpreter;

    private SchemaInterpreter() {}

    public static SchemaInterpreter getInstance(){
        if(schemaInterpreter == null){
            schemaInterpreter = new SchemaInterpreter();
        }
        return schemaInterpreter;
    }

    public boolean validateTree(Node rootNode, String path) throws IOException {
        SchemaConstructor schemaConstructor = new SchemaConstructor();
        SchemaValidator schemaValidator;
        Schema schema;
        schema = new Schema();

        Constraint qcmConstraint = new Constraint("QCM");
        qcmConstraint.addChild(new Child("QUESTION", true));
        qcmConstraint.addChild(new Child("QUESTION", true));
        schema.addConstraint(qcmConstraint);

        Constraint questionConstraint = new Constraint("QUESTION");
        questionConstraint.addChild(new Child("ANSWER", true));
        schema.addConstraint(questionConstraint);

        Constraint answerConstraint = new Constraint("ANSWER");
        answerConstraint.addChild(new Child("VALIID", true));
        schema.addConstraint(answerConstraint);

        Constraint validConstraint = new Constraint("VALID");
        schema.addConstraint(validConstraint);

        boolean res = false;

        try {
            //schema = schemaConstructor.createSchema(path);
            schemaValidator = new SchemaValidator(schema);
            res = schemaValidator.isValid(rootNode);
            //TODO maybe should we create convenience method for the validator ?
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
