package XMLLiteParser.States.ParserStates;

import XMLLiteParser.Exception.EmptyNameException;
import XMLLiteParser.Core.Parser;
import XMLLiteParser.States.State;

/**
 * Created by MrMan on 14/09/2016.
 */
public class NewTag implements State {
    @Override
    public State transition(char c) throws EmptyNameException {
        if (c == '/')
            return new NewClosingTag();
        else if ((c != '<') && (c != '>')) {
            Parser.getInstance().fillBuffer(c);
            return new NewTagName();
        }else
            throw new EmptyNameException();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
