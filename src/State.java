/**
 * Created by MrMan on 12/09/2016.
 */
public interface State {
    State transition(char lol);
    boolean validate();
}
