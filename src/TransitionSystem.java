import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.io.*;
import java.nio.charset.Charset;


public class TransitionSystem {

    private String filePath;
    private File file;
    private InputStream inputStream;
    private Reader reader;
    private Reader buffer;
    private Charset encoding;

    /**
     * @param filePath
     */
    public TransitionSystem(String filePath) {
        this.filePath = filePath;
        encoding = Charset.defaultCharset();
        file = new File(filePath);
    }

    /**
     * @throws IOException
     */
    private void handleFile() throws IOException {
        inputStream = new FileInputStream(file);
        reader = new InputStreamReader(inputStream, encoding);
        buffer = new BufferedReader(reader);
    }

    /**
     * @return
     * @throws Exception
     */
    private char nextChar() throws Exception {
        if (buffer != null)
            return (char)buffer.read();
        else
            throw new Exception("Pas de buffer à lire");
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

    /*
     * GETTERS AND SETTERS
     */

    /**
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
