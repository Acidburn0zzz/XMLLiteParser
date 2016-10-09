package XMLLiteParser.States;

import XMLLiteParser.Exception.EmptyNameException;
import XMLLiteParser.Core.Parser;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FirstTagOpening implements State {
    @Override
    public State transition(char c) throws EmptyNameException {
        if (c != '<' && c != '>' && c != '/') {
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