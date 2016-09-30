/**
 * Created by MrMan on 28/09/2016.
 */
public class UnexpectedClosingNameException extends Throwable {
    private String message;

    public UnexpectedClosingNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
