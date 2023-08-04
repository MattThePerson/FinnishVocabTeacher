

public class App {

    public static void main(String [] args) throws Exception 
    {
        //
    }

    private static void program1() throws Exception {
        String filename = "something.csv";
        DataHandler dhCSV = new DataHandlerCSV(filename);
        FinnishVocabTeacher.setDataHandler(dhCSV);
        FinnishVocabTeacher.loadProgram();
        FinnishVocabTeacherCLI.start();
    }
}