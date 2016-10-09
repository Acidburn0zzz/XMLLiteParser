package XMLLiteParser.States.ParserStates;

import XMLLiteParser.Core.Parser;
import XMLLiteParser.States.State;

import java.lang.*;

/**
 * Created by MrMan on 14/09/2016.
 */
public class NewClosingTag implements State {
    @Override
    public State transition(char c) {
        if(c != '<' && c != '>' && c != '/'){
            Parser.getInstance().fillBuffer(c);
            return new ClosingTagName();
        }else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
