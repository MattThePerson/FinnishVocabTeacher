import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Toggle 'lookForExistingFile' to either preserve existing JSON file or create new object from CSV data, 
 * which will purge program metadata and word metadata
 */
public class CsvWordstoJson {

    private static Boolean lookForExistingFile = true;

    private static FileWriter fWriter;
    private static JSONParser parser;
    private static Scanner sc;
    
    private static String CSVfilename = "finnishWords.csv";
    private static String JSONfilename = "programData.json";
    
    @SuppressWarnings("unchecked")
    public static void main(String [] args) throws Exception {
        
        JSONObject obj, words;
        
        // Create JSONObject, either from existing file or anew 
        if (lookForExistingFile) {
            try {
                System.out.println("\nLoading JSON object from existing file ...");
                parser = new JSONParser();
                obj = (JSONObject) parser.parse(new FileReader(JSONfilename));
            } catch (Exception e) {
                System.out.println("\nJSON file doesn't exist, creating new JSON object ...");
                obj = new JSONObject();
            }
        } else {
            obj = new JSONObject();
        }
        if (obj.containsKey("words")) {
            words = (JSONObject) obj.get("words");
        } else {
            words = new JSONObject();
        }
        
        // Scan CSV file to JSONObject
        sc = new Scanner(new File(CSVfilename));
        sc.useDelimiter(";");
        String [] headerValues = sc.nextLine().split(";");
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String [] lineValues = line.split(";");
            JSONObject word = (JSONObject) words.get(lineValues[0]);
            if (word == null) {
                word = new JSONObject();
            }
            for (int i = 1; i < lineValues.length; i++) {
                word.put(headerValues[i], lineValues[i]);
            }
            words.put(lineValues[0], word);
        }
        obj.put("words", words);
        sc.close();

        // Save JSON data to file
        try {
            fWriter = new FileWriter(JSONfilename);
            fWriter.write(obj.toJSONString());
            fWriter.flush();
            fWriter.close();
            System.out.println("Successfully wrote data to JSON file\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
