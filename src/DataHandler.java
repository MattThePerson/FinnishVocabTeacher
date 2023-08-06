// meant to be implemented by class that handles data saving and loading in specific way, 
// eg. saving to csv file or to database

import java.util.List;

interface DataHandler {
    
    public void loadData() throws Exception;
    public WordContainer getWords() throws Exception;
    public Boolean saveToFile(List<Word> words) throws Exception;
}
