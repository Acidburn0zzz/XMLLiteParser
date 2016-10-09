package XMLLiteParser.Core;

import XMLLiteParser.Exception.EmptyNameException;
import XMLLiteParser.Exception.NodeBeforeContentException;
import XMLLiteParser.Exception.UnexpectedClosingNameException;
import XMLLiteParser.IO.FileReader;
import XMLLiteParser.States.InitialState;
import XMLLiteParser.States.State;

import java.io.IOException;


public class TransitionSystem {

    public void parseFile(String path) throws IOException{
        //TODO Shouldn't the parser return the rootNode and not let the user acces the parser instance ?
        FileReader fileReader = new FileReader(path);
        State currentState = new InitialState();
        char code = fileReader.nextChar();

        while (code != 65535){
            try {
                currentState = currentState.transition(code);
            } catch (NodeBeforeContentException e) {
                int[] res = fileReader.getCurrentPosition();
                System.err.println("Unexpected content after a node at line : " + res[0] + ", character : " + res[1]);
                break;
            } catch (UnexpectedClosingNameException e) {
                int[] res = fileReader.getCurrentPosition();
                System.err.println("Unexpected closing name at line : " + res[0] + ", character : " + res[1] + "\n"
                                        + e.getMessage());
                break;
            } catch (EmptyNameException e) {
                int[] res = fileReader.getCurrentPosition();
                System.err.println("Empty new tag name at line : " + res[0] + ", character : " + res[1]);
                break;
            }

            code = fileReader.nextChar();
            while(code == '\r' || code == '\n')
                code = fileReader.nextChar();
        }

        fileReader.close();

        if(!Parser.getInstance().isRootNodeClosed())
            System.err.println("The root node has not been closed");
    }
}
