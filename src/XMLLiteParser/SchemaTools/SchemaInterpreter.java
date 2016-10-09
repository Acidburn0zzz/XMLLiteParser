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

        boolean res = false;

        try {
            schema = schemaConstructor.createSchema(path);
            schemaValidator = new SchemaValidator(schema);
            res = schemaValidator.isValid(rootNode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
