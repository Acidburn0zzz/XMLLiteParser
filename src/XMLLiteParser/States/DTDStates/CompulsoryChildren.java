package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class CompulsoryChildren implements State {
    @Override
    public State transition(char c) {
        if(c == ','){
            return new NextChildrenPoint();
        }else if(c == ')'){
            return new ClosingParenthesis();
        }else{
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
