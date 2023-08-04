import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class DataHandlerJSON {

    private String filename;
    private FileReader fReader;
    private JSONParser parser;
    private JSONObject jsonObj;

    public DataHandlerJSON() {
        //
    }

    public DataHandlerJSON(String filename) {
        this.filename = filename;
    }

    public void loadData() {
        parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filename));
            jsonObj = (JSONObject) obj; 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WordMetadata> getWords() {
        
        return new ArrayList<>();
    }
    
    public void saveData() {
        //
    }


    //// SETTERS ////

    public void setFilename(String fn) {
        this.filename = fn;
    }
}