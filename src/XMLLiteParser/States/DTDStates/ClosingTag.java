package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class ClosingTag implements State {
    @Override
    public State transition(char c) {
        if (c == '<'){
            return new OpeningTag();
        }else{
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
