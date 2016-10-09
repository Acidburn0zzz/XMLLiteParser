package XMLLiteParser.States.DTDStates;

import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class ChildName implements State {
    @Override
    public State transition(char c) {
        if (String.valueOf(c).matches("[a-zA-Z]") || c == '_' || c == '-'){
            return this;
        }else if(c == '+'){
            return new CompulsoryChildren();
        }else if(c == ','){
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
