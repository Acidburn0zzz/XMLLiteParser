package XMLLiteParser;

import java.io.*;

/**
 * Created by MrMan on 03/10/2016.
 */
public class Logger {
    private static Logger instance;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    private Logger(){
        try {
            fileWriter = new FileWriter("log.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    public void append(char c){
        try {
            bufferedWriter.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
