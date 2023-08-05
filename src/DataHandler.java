// meant to be implemented by class that handles data saving and loading in specific way, 
// eg. saving to csv file or to database

import java.util.List;

interface DataHandler {
    
    public void loadData() throws Exception;
    public List<WordMetadata> getWords() throws Exception;
    public Boolean saveToFile(List<WordMetadata> words) throws Exception;
}
