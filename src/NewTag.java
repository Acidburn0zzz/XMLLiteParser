/**
 * Created by MrMan on 14/09/2016.
 */
public class NewTag implements State {
    @Override
    public State transition(char c) throws EmptyNameException {
        if (c == '/')
            return new NewClosingTag();
        else if ((c != '<') && (c != '>')) {
            XMLLiteParser.getInstance().fillBuffer(c);
            return new NewTagName();
        }else
            throw new EmptyNameException();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
