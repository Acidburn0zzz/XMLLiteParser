import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.io.IOException;


public class TransitionSystem {

    private FileReader fileReader;
    private State currentState;

    public TransitionSystem(){

    }

    public void openXMLFile(String path) throws IOException {
        fileReader = new FileReader(path);
    }

    public void start(){
        currentState = new InitialState();
        int code = 0;
        while (code != -1 && currentState.isFinal() == false){
            try {
                code = fileReader.nextChar();
            } catch (Exception e) {
                if (e.getMessage() == "EOF")
                    code = -1;
                else if (e.getMessage() == "Pas de buffer à lire")
                    ; // you just don't understand my skills
            }
            if(code != -1){
                currentState.transition((char)code);
            }
        }

    }

    public State getEvent(){
        throw new NotImplementedException();
    }

    /**
     *
     */
    public void next(){
        throw new NotImplementedException();
    }

    /**
     * @return
     */
    public boolean validate(){
        throw new NotImplementedException();
    }
}
