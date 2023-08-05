import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
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
            Object obj = parser.parse(new FileReader(filename));
            jsonObj = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Cycles through words to
     */
    @Override
    public List<WordMetadata> getWords() {
        
        return new ArrayList<>();
    }
    
    @Override
    public Boolean saveToFile(List<WordMetadata> words) throws Exception {
        
        // Convert words (and metadata) into new JSONObject
        JSONObject jsonObj = new JSONObject();

        // Write to file
        try {
            fWriter = new FileWriter(filename);
            fWriter.write(jsonObj.toJSONString());
            fWriter.flush();
            fWriter.close();
            System.out.println("Successfully wrote data to json file '" + filename + "'\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return true;
    }


    //// SETTERS ////

    public void setFilename(String fn) {
        this.filename = fn;
    }


    
}