package XMLLiteParser.SchemaTools;

import XMLLiteParser.Exception.InvalidDocumentException;
import XMLLiteParser.IO.FileReader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MrMan on 05/10/2016.
 */
public class SchemaConstructor {

    public Schema createSchema(String path) throws IOException, InvalidDocumentException {
        //TODO find a working regex and build the schema with it
        Schema schema = new Schema();
        FileReader fileReader = new FileReader(path);
        String doc = fileReader.readFile();
        String[] lines = doc.split("\n");

        Pattern linePattern = Pattern.compile("^<!ELEMENT ([a-zA-Z]+) [\\(?[a-zA-Z]+\\+?\\,? ?\\)?]*>"); //Regex pour une ligne
        Matcher lineMatcher;

        for (String line: lines) {
            System.out.println(line);
            lineMatcher = linePattern.matcher(line +" ");
            System.out.println(lineMatcher.matches());
        }

//        if(!lineMatcher.matches())
//            throw new InvalidDocumentException("The document doesn't match the .dtd pattern");

        //2 is the constraint name
        //3 is the child name like this : child+, child, child, child

//        int groupCount = lineMatcher.groupCount();
//
//        for (int i = 1; i < groupCount; i++) {
//            lineMatcher = linePattern.matcher(lineMatcher.group(i));
//            Constraint constraint = new Constraint(lineMatcher.group(1));
//
//            for (int j = 2; j < lineMatcher.groupCount(); j++) {
//                String childName = lineMatcher.group(j);
//                Child child;
//
//                if(childName.contains("+"))
//                    child = new Child(childName.subSequence(0, childName.indexOf('+')).getName(), true);
//                else
//                    child = new Child(childName, false);
//
//                constraint.addChild(child);
//            }
//
//            schema.addConstraint(constraint);
//        }

        return schema;
    }
}
