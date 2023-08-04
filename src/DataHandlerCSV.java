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
    public Boolean save(List<WordMetadata> words) throws Exception {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(header);
            bw.newLine();
            for (WordMetadata wc : words) {
                String line = wordMetadataToString(wc);
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
    public List<WordMetadata> loadWords() throws Exception
    {
        List<WordMetadata> words = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            header = br.readLine();
            String line;
            while ( (line = br.readLine()) != null) {
                words.add(stringToWordMetadata(line));
            }
            br.close();
        } catch (Exception e) {
            return null;
        }
        return words;
    }

    private WordMetadata stringToWordMetadata(String line) {
        String [] values = line.split(",");
        return new WordMetadata();
    }

    private String wordMetadataToString(WordMetadata wc) {
        String [] data = {"Juosta", "Liikkua jaloikka nopeasti", "Holkätä", "Run"};
        return String.join(",", data);
    }
}
