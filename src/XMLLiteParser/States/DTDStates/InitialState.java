package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class InitialState implements State {
    @Override
    public State transition(char c) {
        if(c != '<'){
            return new Error();
        }else{
            return new OpeningTag();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
