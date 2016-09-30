/**
 * Created by MrMan on 14/09/2016.
 */
public class TextContent implements State {
    @Override
    public State transition(char c) throws NodeBeforeContentException {
        if (c == '<') {
            XMLLiteParser.getInstance().fillNodeContent();
            return new NewTag();
        }else if ((c != '/') && (c != '>')) {
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
