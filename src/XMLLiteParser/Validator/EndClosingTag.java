package XMLLiteParser.Validator;

import XMLLiteParser.Error;
import XMLLiteParser.State;

/**
 * Created by MrMan on 14/09/2016.
 */
public class EndClosingTag implements State {
    @Override
    public State transition(char c) {
        if(c == '<')
            return new NewTag();
        else if(c == ' ')
            return this;
        else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
