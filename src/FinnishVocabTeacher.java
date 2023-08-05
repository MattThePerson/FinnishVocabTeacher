import java.util.List;

public class FinnishVocabTeacher {

    private static List<WordMetadata> words;
    private static DataHandler dataHandler;

    public FinnishVocabTeacher() {
        //
    }

    /*
     * Start Program
     */
    public static void startProgram() throws Exception {
        if (dataHandler == null) {
            System.out.println("Error: Data handler has not been set");
            return;
        }
        loadData();
        
    }

    /*
     * load data
     */
    public static void loadData() throws Exception {
        try {
            words = dataHandler.getWords();
        } catch (Exception e) {
            System.out.println("Error: Unable to load words, reading from csv file failed");
        }
    }

    /// SETTERS ///
    public static void setDataHandler(DataHandler dh) {
        dataHandler = dh;
    }
}
