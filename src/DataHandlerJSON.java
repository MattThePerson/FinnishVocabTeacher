import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class DataHandlerJSON implements DataHandler {

    private String filename;
    private FileWriter fWriter;
    private JSONParser parser;
    private JSONObject jsonObj;

    public DataHandlerJSON() {
        //
    }

    
    public DataHandlerJSON(String filename) {
        this.filename = filename;
    }

    /*
     * Loads contents of filename into jsonObj
     */
    @Override
    public void loadData() {
        parser = new JSONParser();
        try {
            jsonObj = (JSONObject) parser.parse(new FileReader(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Assumes that jsonObj exists.
     * Cycles 
     */
    @Override
    public WordContainer getWords() {
        if (jsonObj == null) {
            System.out.println("\nWarning: data has not been loaded yet\n");
            return null;
        }
        WordContainer wc = new WordContainer();
        JSONObject words = (JSONObject) jsonObj.get("words");
        for (Object key : words.keySet()) {
            Word newWord = jsonToWord(key, words.get(key));
            wc.add(newWord);
        }
        return wc;
    }
    
    /*
     * save to file
     */
    @Override
    @SuppressWarnings("unchecked")
    public Boolean saveToFile(List<Word> words) throws Exception {
        // Convert words (and metadata) into new JSONObject
        JSONObject jsonObj = new JSONObject();
        JSONObject wordsObj = new JSONObject();
        for (Word w : words) {
            wordsObj.put(w.getWord(), wordToJson(w));
        }
        jsonObj.put("words", wordsObj);
        // Write to file
        try {
            fWriter = new FileWriter(filename);
            fWriter.write(jsonObj.toJSONString());
            fWriter.flush();
            fWriter.close();
            //System.out.println("Successfully wrote data to json file '" + filename + "'\n");
        } catch (Exception e) {
            System.out.println("Error: unable to write to JSON file");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private Word jsonToWord(Object key, Object values) {
        JSONObject valuesJson = (JSONObject) values;
        Word word = new Word((String)key);
        word.setDefinition((String)valuesJson.get("definition"));
        String finnishSynonymsString = (String)valuesJson.get("finnishSynonyms");
        word.setFinnishSynonyms(finnishSynonymsString.split(","));
        return word;
    }

    /*
     * attributes to be converted:
     * - String defitition
     * - String [] finnishSynonyms
     */
    @SuppressWarnings("unchecked")
    private JSONObject wordToJson(Word w) {
        JSONObject wordObj = new JSONObject();
        wordObj.put("definition", w.getDefinition());
        wordObj.put("finnishSynonyms", String.join(",", w.getFinnishSynonyms()));
        return wordObj;
    }

    //// SETTERS ////

    public void setFilename(String fn) {
        filename = fn;
    }
}