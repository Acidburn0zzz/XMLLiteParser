package XMLLiteParser.Exception;

/**
 * Created by MrMan on 06/10/2016.
 */
public class InvalidDocumentException extends Exception {
    public InvalidDocumentException() {
    }

    public InvalidDocumentException(String message) {
        super(message);
    }

    public InvalidDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDocumentException(Throwable cause) {
        super(cause);
    }

    public InvalidDocumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
