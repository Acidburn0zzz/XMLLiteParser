/**
 * Created by MrMan on 14/09/2016.
 */
public class EndClosingTag implements State {
    @Override
    public State transition(char c) {
        if(c == '<')
            return new NewTag();
        else if(c != '<' && c != '>' && c != '/')
            return new TextContent();
        else
            return new Error();
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
