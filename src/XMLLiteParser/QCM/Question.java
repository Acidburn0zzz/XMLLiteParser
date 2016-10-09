package XMLLiteParser.QCM;

import java.util.ArrayList;

/**
 * Created by MrMan on 09/10/2016.
 */
public class Question {
    String question;
    ArrayList<Answer> answers;

    public Question(String question) {
        this.question = question;
        answers = new ArrayList<>();
    }

    //region Getters and setters
    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    //endregion
}
