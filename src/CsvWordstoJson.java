import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class CsvWordstoJson {

    private static String header;
    private static FileWriter fWriter;
    private static String CSVfilename = "finnishWords.csv";
    private static String JSONfilename = "programData.json";
    
    @SuppressWarnings("unchecked")
    public static void main(String [] args) throws Exception {
        
        // Read csv file and put into JSON Object
        JSONObject obj = new JSONObject();
        JSONObject words = new JSONObject();
        
        Scanner sc = new Scanner(new File(CSVfilename));
        sc.useDelimiter(";");
        
        header = sc.nextLine();
        while (sc.hasNext()) {

            JSONObject word = new JSONObject();
            String [] items = sc.nextLine().split(";");

            for (int i = 1; i < items.length; i++) {
                word.put(Integer.toString(i), items[i]);
            }
            words.put(items[0], word);
        }
        sc.close();
        obj.put("words", words);

        // Save JSON data to file
        try {
            fWriter = new FileWriter(JSONfilename);
            fWriter.write(obj.toJSONString());
            fWriter.flush();
            fWriter.close();
            System.out.println("Successfully wrote data to JSON file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
