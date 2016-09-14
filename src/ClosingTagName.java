/**
 * Created by MrMan on 14/09/2016.
 */
public class ClosingTagName implements State {
    @Override
    public State transition(char c) {
        if(c == '>')
            return new EndClosingTag();
        else if(c != '<' && c != '>' && c != '/')
            return this; //Closing tag name goes on
        else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
