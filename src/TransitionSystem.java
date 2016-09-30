import java.io.IOException;


public class TransitionSystem {

    public void parseFile(String path) throws IOException{
        FileReader fileReader = new FileReader(path);
        State currentState = new InitialState();
        char code = fileReader.nextChar();

        while (code != 0){
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

        if(!XMLLiteParser.getInstance().isRootNodeClosed())
            System.err.println("The root node has not been closed");
    }
}
