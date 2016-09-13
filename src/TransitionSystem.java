import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by MrMan on 12/09/2016.
 */
public class TransitionSystem {

    private String filePath;
    private File file;
    private Reader reader;
    private Reader buffer;

    public TransitionSystem(String filePath) {
        this.filePath = filePath;
        Charset encoding = Charset.defaultCharset();
        file = new File(filePath);

    }

    private void handleFile(File file, Charset encoding)
            throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             buffer = new BufferedReader(reader)) {
        }
    }

    private char nextChar() throws IOException {
        return (char)buffer.read();
    }
    public State getEvent(){
        throw new NotImplementedException();
    }
    public void next(){
        throw new NotImplementedException();
    }
    public boolean validate(){
        throw new NotImplementedException();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
