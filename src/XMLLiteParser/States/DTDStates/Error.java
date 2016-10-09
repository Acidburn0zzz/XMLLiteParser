package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class Error implements State {
    @Override
    public State transition(char c) {
        return this;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
