package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class FinalState implements State {
    @Override
    public State transition(char c) {
        return null;
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
