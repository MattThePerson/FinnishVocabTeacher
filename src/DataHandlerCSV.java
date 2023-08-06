import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataHandlerCSV implements DataHandler {

    private static String filename;
    private static String header;

    public DataHandlerCSV() {
        //
    }
    
    public DataHandlerCSV(String fn) {
        filename = fn;
    }

    @Override
    public Boolean saveToFile(List<Word> words) throws Exception {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(header);
            bw.newLine();
            for (Word wc : words) {
                String line = wordToString(wc);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Successfully saved data to csv file");

        } catch (Exception e) {
            //
        }
        return true;
    }

    @Override
    public WordContainer getWords() throws Exception
    {
        List<Word> words = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            header = br.readLine();
            String line;
            while ( (line = br.readLine()) != null) {
                words.add(stringToWord(line));
            }
            br.close();
        } catch (Exception e) {
            return null;
        }
        return new WordContainer(words);
    }

    private Word stringToWord(String line) {
        String [] values = line.split(",");
        return new Word();
    }

    private String wordToString(Word wc) {
        String [] data = {"Juosta", "Liikkua jaloikka nopeasti", "Holkätä", "Run"};
        return String.join(",", data);
    }

    @Override
    public void loadData() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadData'");
    }
}
