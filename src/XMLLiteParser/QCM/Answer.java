package XMLLiteParser.QCM;

/**
 * Created by MrMan on 09/10/2016.
 */
public class Answer {
    private String answer;
    private boolean valid;

    public Answer(String answer, boolean valid) {
        this.answer = answer;
        this.valid = valid;
    }

    //region Getters and setters
    public String getAnswer() {
        return answer;
    }

    public boolean isValid() {
        return valid;
    }
    //endregion
}
