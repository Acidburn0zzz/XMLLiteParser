import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Antoine on 14/09/2016.
 */
public class FileReader {
    private InputStreamReader reader;
    private File file;
    private InputStream inputStream;
    private Reader bufferedReader;
    private char[] buffer;
    private int index;
    private int offset;
    private static final int LENGTH = 2048;
    private Charset encoding;


    public FileReader(String path) throws IOException {
        encoding = Charset.defaultCharset();
        file = new File(path);
        handleFile(file);
        bufferedReader.mark(LENGTH);
        buffer = new char[LENGTH];
        bufferedReader.read(buffer);
        index = 0;
        offset = 0;
    }

    public void handleFile(File file) throws FileNotFoundException {
        inputStream = new FileInputStream(file);
        reader = new InputStreamReader(inputStream, encoding);
        bufferedReader = new BufferedReader(reader);
    }

    public char nextChar() throws IOException{
        char c;
        if(index < LENGTH) {
            c = buffer[index];
        }
        else{
            bufferedReader.read(buffer, 0, LENGTH);
            offset += LENGTH;
            index = 0;
            c = buffer[index];
        }
        index++;
        return c;
    }

    public int[] getCurrentPosition() throws IOException {
        if(offset == 0)
            offset = index;

        handleFile(file);

        bufferedReader.mark(offset);
        buffer = new char[offset];
        bufferedReader.read(buffer, 0, offset);
        char c = buffer[0];

        int line = 0;
        int character = 0;
        index = 0;

        while(c != 0 && index < offset){
            if(c == 13){
                line++;
                character = 0;
            }
            character++;
            c = buffer[index++];
        }

        int[] res = new int[2];
        res[0] = line;
        res[1] = character;

        return res;
    }

    public void close(){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
