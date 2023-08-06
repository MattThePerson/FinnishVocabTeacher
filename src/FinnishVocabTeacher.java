import java.util.List;
import java.util.Scanner;

public class FinnishVocabTeacher {

    private static FinnishVocabTeacher instance;

    private WordContainer words;
    private DataHandler dataHandler;
    private Scanner sc;

    private String [] mainMenuOptions = 
    {"Exit", "Save", "Print all words", "Search word", "Do daily practice", "Add word", "Do one random word", "Edit learning curve", "Dev options"};

    private String [] devOptions = {"Purge word metadata", "Purge program metadata", "Delete word"};


    private FinnishVocabTeacher() {}

    public static FinnishVocabTeacher getInstance() {
        if (instance == null) {
            instance = new FinnishVocabTeacher();
        }
        return instance;
        
    }


    ////  INTERFACING METHODS  ////

    /*
     * Start Program
     */
    public void start() throws Exception {
        println("\nStarting program ...");
        if (dataHandler == null) {
            System.out.println("Error: Data handler has not been set");
            return;
        }
        loadData();
        cliLoop();
    }

    /*
     * Gets words and metadata from dataHandler
     */
    public void loadData() throws Exception {
        System.out.println("Loading data ...");
        try {
            dataHandler.loadData();
            System.out.println("Data loaded from file ...");
            words = dataHandler.getWords();
            System.out.println("Words aquired from data handler ...");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error: Unable to load data");
        }
    }

    
    ////  PRIVATE METHODS  ////

    /*
     * cliLoop()
     */
    private void cliLoop() throws Exception {
        
        Boolean unsavedChanges = false;
        sc = new Scanner(System.in);
        String s;
        
        println("\n---- Welcome to Finnish Vocab Teacher ----\n");
        pause();
        s = "";

        while ("0".equals(s) == false)
        {
            print("\nMAIN MENU\n");
            printMenuOptions(mainMenuOptions);

            s = sc.nextLine();
            if ("0".equals(s)) { // exit
                // exit

            } else if ("1".equals(s)) { // save
                println("\nSaving data to file ...");
                List<Word> wordList = words.getWordList();
                if (wordList != null) {
                    dataHandler.saveToFile(wordList);
                } else {
                    println("Warning: No words to save");
                }
                println("... successfully written to file!\n");
                pause();

            } else if ("2".equals(s)) {
                println("Printing all words in word container: \n");
                for (Word w : words.getWordList()) {
                    println(w + " :: " + w.getDefinition());
                    print("finnish synonyms: ");
                    for (String syn : w.getFinnishSynonyms()) {
                        print(syn + " ");
                    }
                    println("\n");
                }
                println();
                pause();

            } else if ("3".equals(s)) {
                
                searchWordCLI();
                
            } else if ("4".equals(s)) {
                //
                
            }
        }
    }


    /*
     * searchWordCLI
     */
    private void searchWordCLI() {
        String s = "";
        while (!"0".equals(s)) {
            println("\nType a word to search for (type 0 to exit):\n> ");
        }

    }


    ////  UTILITY METHODS  ////

    private void printMenuOptions(String [] menuOptions) {
        for (int i = 0; i < menuOptions.length; i++) {
            String line = Integer.toString(i) + ") " + menuOptions[i];
            println(line);
        }
        print("> ");
    }


    /// METHODS FOR PRINTING ///
    private static void println() { System.out.println(); }
    private static void println(String s) { System.out.println(s); }
    private static void print(String s) { System.out.print(s); }
    
    private void pause() {
        print("Press enter to continue ... ");
        sc.nextLine();
    }

    ////  GETTERS & SETTERS  ////
    public void setDataHandler(DataHandler dh) {
        dataHandler = dh;
    }
}
