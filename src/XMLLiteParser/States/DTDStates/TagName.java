package XMLLiteParser.States.DTDStates;

import XMLLiteParser.Exception.EmptyNameException;
import XMLLiteParser.SchemaTools.DTDParser;
import XMLLiteParser.States.State;

/**
 * Created by Mathis on 09/10/2016.
 */
public class TagName implements State {
    @Override
    public State transition(char c) throws EmptyNameException {
        if (String.valueOf(c).matches("[a-zA-Z]") || c == '_' || c == '-') {
            DTDParser.getInstance().fillBuffer(c);
            return this;
        }
        else if(c == ' '){
            DTDParser.getInstance().createConstraint();
            return new SecondSpace();
        }else if(c == '(') {
            DTDParser.getInstance().createConstraint();
            return new OpeningParenthesis();
        }else{
            return new Error();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
