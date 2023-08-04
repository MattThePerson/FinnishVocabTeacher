import java.util.List;

public class FinnishVocabTeacher {
    
    private static List<WordMetadata> words;
    private static DataHandler dataHandler;

    public FinnishVocabTeacher() {
        //
    }
    
    public static void setDataHandler(DataHandler dh) {
        dataHandler = dh;
    }

    public static void loadProgram() throws Exception {
        try {
            words = dataHandler.loadWords();
        } catch (Exception e) {
            System.out.println("Error: Unable to load words, reading from csv file failed");
        }
    }
}
