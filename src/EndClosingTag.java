/**
 * Created by MrMan on 14/09/2016.
 */
public class EndClosingTag implements State {
    @Override
    public State transition(char c) {
        if(c == '<')
            return new NewTag();
        else
            return new TextContent();
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
