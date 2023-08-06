

public class App {

    public static void main(String [] args) throws Exception 
    {
        String jsonFilename = "programData.json";
        FinnishVocabTeacher program = FinnishVocabTeacher.getInstance();
        program.setDataHandler(new DataHandlerJSON(jsonFilename));
        program.start();
    }
}