/**
 * Created by MrMan on 14/09/2016.
 */
public class NewTag implements State {
    @Override
    public State transition(char c) {
        if (c == '/')
            return new NewClosingTag();
        else if ((c == '<') || (c == '>'))
            return new Error();
        else
            return new NewTagName();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
