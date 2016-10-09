package XMLLiteParser.SchemaTools;
import XMLLiteParser.IO.FileReader;
import XMLLiteParser.States.DTDStates.*;
import XMLLiteParser.States.State;

import java.io.IOException;

/**
 * Created by MrMan on 09/10/2016.
 */
public class TransitionSystem {
    public Schema parseFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        State currentState = new InitialState();
        char code = fileReader.nextChar();

        while (code != 65535) {
            try {
                currentState = currentState.transition(code);
            } catch (Throwable e) {
                e.printStackTrace();
            }

            code = fileReader.nextChar();
            while (code == '\r' || code == '\n')
                code = fileReader.nextChar();
        }

        fileReader.close();
        return DTDParser.getInstance().getSchema();
    }
}
