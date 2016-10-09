package XMLLiteParser.QCM;

import java.util.ArrayList;

/**
 * Created by MrMan on 09/10/2016.
 */
public class QCM {
    private ArrayList<Question> questions = new ArrayList<>();

    //region Getters and setters
    public void addQuestion(Question question){
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    //endregion
}
