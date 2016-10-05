import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FileReader {
    private InputStreamReader reader;
    private File file;
//    private Logger logger; //Only for debugging
    private InputStream inputStream;
    private Reader bufferedReader;
    private int index;


    public FileReader(String path) throws IOException {
        file = new File(path);
        handleFile(file);
        index = 0;
    }

    private void handleFile(File file) throws IOException {
        inputStream = new FileInputStream(file);
//        logger = Logger.getInstance();  Only for debugging

        reader = new InputStreamReader(inputStream, Charset.defaultCharset());
        bufferedReader = new BufferedReader(reader);
    }

    public char nextChar() throws IOException{
        index++;
        return (char)bufferedReader.read();
    }

    public int[] getCurrentPosition() throws IOException {
        handleFile(file);
        int line = 0;
        int character = 0;

        for (int i = 0; i < index; i++) {
            if(nextChar() == 13){
                line++;
                character = 1;
            } else {
                character++;
            }
        }

        return new int[] {line, character};
    }

    public void close(){
        try {
//            logger.close(); only for debugging
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
