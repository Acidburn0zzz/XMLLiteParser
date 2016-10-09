package XMLLiteParser.States;

import java.lang.*;

/**
 * Created by MrMan on 14/09/2016.
 */
public class InitialState implements State {
    @Override
    public State transition(char c) {
        if(c != '<')
            return new Error();
        else
            return new FirstTagOpening();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
