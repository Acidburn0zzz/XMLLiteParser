package XMLLiteParser.Validator;

import XMLLiteParser.Error;
import XMLLiteParser.Parser;
import XMLLiteParser.State;

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
