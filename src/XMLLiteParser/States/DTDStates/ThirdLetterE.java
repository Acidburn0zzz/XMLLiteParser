package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class ThirdLetterE implements State {
    @Override
    public State transition(char c) {
        if (c == 'N'){
            return new LetterN();
        }else{
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
