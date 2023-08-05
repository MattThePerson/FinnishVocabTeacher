

public class App {

    public static void main(String [] args) throws Exception 
    {
        String filename = "data.json";
        FinnishVocabTeacher.setDataHandler(new DataHandlerJSON(filename));
        FinnishVocabTeacher.startProgram();
    }





    private static void program1() throws Exception {
        String filename = "something.csv";
        DataHandler dhCSV = new DataHandlerCSV(filename);
        FinnishVocabTeacher.setDataHandler(dhCSV);
        FinnishVocabTeacher.loadData();
        FinnishVocabTeacherCLI.start();
    }
}