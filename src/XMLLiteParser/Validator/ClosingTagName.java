package XMLLiteParser.Validator;

import XMLLiteParser.Error;
import XMLLiteParser.Parser;
import XMLLiteParser.State;
import XMLLiteParser.Exception.UnexpectedClosingNameException;

/**
 * Created by MrMan on 14/09/2016.
 */
public class ClosingTagName implements State {
    @Override
    public State transition(char c) throws UnexpectedClosingNameException {
        if(c == '>') {
            Parser.getInstance().closeNode();
            return new EndClosingTag();
        }else if(c != '<' && c != '>' && c != '/') {
            Parser.getInstance().fillBuffer(c);
            return this; //Closing tag name goes on
        }else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
