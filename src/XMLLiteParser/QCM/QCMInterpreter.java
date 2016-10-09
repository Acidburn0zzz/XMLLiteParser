package XMLLiteParser.QCM;

import XMLLiteParser.Exception.InvalidDocumentException;
import XMLLiteParser.Core.Node;
import XMLLiteParser.SchemaTools.SchemaInterpreter;

import java.io.IOException;

/**
 * Created by MrMan on 09/10/2016.
 */
public class QCMInterpreter {
    /**
     * @param rootNode The rootnode of the tree representing the QCM
     * @return The QCM object
     * @throws InvalidDocumentException if the tree doesn't respect a QCM schema
     */
    public QCM interpreteTree(Node rootNode) throws InvalidDocumentException, IOException {
        QCM qcm = new QCM();
        SchemaInterpreter schemaInterpreter = SchemaInterpreter.getInstance();

        if(!schemaInterpreter.validateTree(rootNode, "XMLDocs\\QCM.dtd"))
            throw new InvalidDocumentException("The tree doesn't respect a QCM schema");

        int questionCount = rootNode.getChildCount();
        for (int i = 0; i < questionCount; i++) {
            Node questionNode = (Node) rootNode.getChildAt(i);
            Question question = new Question(questionNode.getContent());
            int answerCount = questionNode.getChildCount();

            for (int j = 0; j < answerCount; j++) {
                Node answerNode = (Node) questionNode.getChildAt(j);
                Answer answer;
                if (answerNode.getChildCount() != 0) {
                    if (((Node) answerNode.getChildAt(0)).getContent().contains("true"))
                        answer = new Answer(answerNode.getContent(), true);
                    else
                        answer = new Answer(answerNode.getContent(), false);
                    question.addAnswer(answer);
                }
            }
            qcm.addQuestion(question);
        }

        return qcm;
    }
}
