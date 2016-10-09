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

    public Schema createSchema(String path) throws IOException {
        return new TransitionSystem().parseFile(path);
    }


}
