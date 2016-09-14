import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FileReader {
    private String filePath;
    private File file;
    private InputStream inputStream;
    private Reader reader;
    private Reader buffer;
    private Charset encoding;

    public FileReader(String path) throws IOException {
        this.filePath = path;
        encoding = Charset.defaultCharset();
        file = new File(filePath);
        handleFile();
    }

    private void handleFile() throws IOException {
        inputStream = new FileInputStream(file);
        reader = new InputStreamReader(inputStream, encoding);
        buffer = new BufferedReader(reader);
    }

    public char nextChar() throws Exception {
        if (buffer != null) {
            int asciiCode = buffer.read();
            if (asciiCode != -1)
                return (char)asciiCode;
            else
                throw new Exception("EOF");
        }
        else
            throw new Exception("Pas de buffer à lire");
    }

    public void close(){
        try {
            inputStream.close();
        } catch (IOException e) {
            ; // #GoodPractice
        }
    }
}
