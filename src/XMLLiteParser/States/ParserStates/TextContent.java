package XMLLiteParser.States.ParserStates;

import XMLLiteParser.Exception.NodeBeforeContentException;
import XMLLiteParser.Core.Parser;
import XMLLiteParser.States.State;

import java.lang.*;

/**
 * Created by MrMan on 14/09/2016.
 */
public class TextContent implements State {
    @Override
    public State transition(char c) throws NodeBeforeContentException {
        if (c == '<') {
            Parser.getInstance().fillNodeContent();
            return new NewTag();
        }else if ((c != '/') && (c != '>')) {
            Parser.getInstance().fillBuffer(c);
            return this;
        }else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
