/**
 * Created by MrMan on 14/09/2016.
 */
public class ClosingTag implements State {
    @Override
    public State transition(char c) {
        if(c == '>')
            return new EndClosingTag();
        else
            return this; //Closing tag name goes on
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
