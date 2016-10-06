package XMLLiteParser;

import XMLLiteParser.Exception.InvalidDocumentException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MrMan on 05/10/2016.
 */
public class SchemaConstructor {

    public Schema createSchema(String path) throws IOException, InvalidDocumentException {
        FileReader fileReader = new FileReader(path);
        String document = fileReader.readFile();
        Schema schema = new Schema();

        Pattern documentPattern = Pattern.compile(""); //Regex pour tout le document
        Pattern linePattern = Pattern.compile(""); //Regex pour une extraire les arguments d'une ligne

        Matcher documentMatcher = documentPattern.matcher(document);
        Matcher lineMatcher;


        if(!documentMatcher.matches())
            throw new InvalidDocumentException("The document doesn't match the .dtd pattern");

        int groupCount = documentMatcher.groupCount();

        for (int i = 1; i < groupCount; i++) {
            lineMatcher = linePattern.matcher(documentMatcher.group(i));
            Constraint constraint = new Constraint(lineMatcher.group(1));

            for (int j = 2; j < lineMatcher.groupCount(); j++) {
                String childName = lineMatcher.group(j);
                Child child;

                if(childName.contains("+"))
                    child = new Child(childName.subSequence(0, childName.indexOf('+')).toString(), true);
                else
                    child = new Child(childName, false);

                constraint.addChild(child);
            }

            schema.addConstraint(constraint);
        }

        return schema;
    }
}
