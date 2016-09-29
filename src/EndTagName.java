/**
 * Created by MrMan on 14/09/2016.
 */
public class EndTagName implements State {
    @Override
    public State transition(char c) {
        if (c == '<')
            return new NewTag();
        else if (c != '<' && c != '>' && c != '/') {
            XMLLiteParser.getInstance().fillBuffer(c);
            return new TextContent();
        } else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
