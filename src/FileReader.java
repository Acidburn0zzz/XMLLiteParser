import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FileReader {
    private InputStreamReader reader;
    private File file;
    private Logger logger;
    private InputStream inputStream;
    private Reader bufferedReader;
    private int index;
    private int offset;
    private static final int LENGTH = 2048;
    private Charset encoding;


    public FileReader(String path) throws IOException {
        encoding = Charset.defaultCharset();
        file = new File(path);
        handleFile(file);
        index = 0;
        offset = 0;
    }

    public void handleFile(File file) throws IOException {
        inputStream = new FileInputStream(file);
        logger = Logger.getInstance();

        reader = new InputStreamReader(inputStream, encoding);
        bufferedReader = new BufferedReader(reader);
    }

    public char nextChar() throws IOException{
        index++;
        char c = (char)bufferedReader.read();
        return c;
    }

    public int[] getCurrentPosition() throws IOException {
        handleFile(file);
        char c = (char) bufferedReader.read();
        int line = 0;
        int character = 0;

        int i = 0;
        while(i < index){
            System.out.println("Je boucle beaucoup");
            if(c == 13){
                line++;
                character = 0;
            }
            character++;
            i++;
            c = (char) bufferedReader.read();
        }

        int[] res = new int[2];
        res[0] = line;
        res[1] = character;

        return res;
    }

    public void close(){
        try {
            logger.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
