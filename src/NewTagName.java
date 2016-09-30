/**
 * Created by MrMan on 14/09/2016.
 */
public class NewTagName implements State {
    @Override
    public State transition(char c) throws EmptyNameException {
        if (c == '>') {
            XMLLiteParser.getInstance().createNode();
            return new EndTagName();
        }else if (c != '<' && c != '/') {
            XMLLiteParser.getInstance().fillBuffer(c);
            return this;
        }else
            return new Error();

    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
