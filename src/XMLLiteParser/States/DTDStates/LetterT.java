package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class LetterT implements State {
    @Override
    public State transition(char c) {
        if (c == ' '){
            return new FirstSpace();
        }else {
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
