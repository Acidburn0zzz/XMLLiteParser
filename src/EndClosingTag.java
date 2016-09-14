/**
 * Created by MrMan on 14/09/2016.
 */
public class EndClosingTag implements State {
    @Override
    public State transition(char c) {
        return null;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
