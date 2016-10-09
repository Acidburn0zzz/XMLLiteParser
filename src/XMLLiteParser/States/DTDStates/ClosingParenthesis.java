package XMLLiteParser.States.DTDStates;

import XMLLiteParser.SchemaTools.DTDParser;
import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class ClosingParenthesis implements State {
    @Override
    public State transition(char c) {
        if (c == '>'){
            DTDParser.getInstance().closeConstraint();
            return new ClosingTag();
        }else{
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
