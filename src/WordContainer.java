import java.util.ArrayList;
import java.util.List;

public class WordContainer {
    
    private List<Word> words;
    
    public WordContainer() {
        words = new ArrayList<>();
    }
    
    public WordContainer(List<Word> words) {
        this.words = words;
    }

    public void add(Word word) {
        words.add(word);
    }

    public List<Word> getWordList() {
        if (words == null) {
            return null;
        }
        return words;
    }
}
