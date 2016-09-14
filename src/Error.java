/**
 * Created by Antoine on 14/09/2016.
 */
public class Error implements State {
    @Override
    public State transition(char c) {
        return this;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
