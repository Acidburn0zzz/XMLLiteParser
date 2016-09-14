import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FirstTagOpening implements State {
    @Override
    public State transition(char c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
