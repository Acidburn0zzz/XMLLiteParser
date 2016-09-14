/**
 * Created by MrMan on 14/09/2016.
 */
public class TextContent implements State {
    @Override
    public State transition(char c) {
        if (c == '<')
            return new NewTag();
        else if ((c != '/') && (c != '>'))
            return this;
        else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
