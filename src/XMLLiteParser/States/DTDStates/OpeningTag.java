package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class OpeningTag implements State {
    @Override
    public State transition(char c) {
        if (c != '!'){
            return new Error();
        }else{
            return new ExclamationPoint();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
