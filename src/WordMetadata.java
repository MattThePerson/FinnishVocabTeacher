import java.util.Date;
import java.util.List;

public class WordMetadata {
    
    private Word word;
    private Boolean useWord = true;
    private int timesAppeared = 0;
    private List<Date> datesAppeared;
    private String [] previousSentences;

    public WordMetadata() {
        //
    }

    public WordMetadata(String word, String definition, String[] finnishSynonyms, String[] englishSynonyms, Boolean useWord, int timesAppeared) {
        this.word = new Word(word, definition, finnishSynonyms, englishSynonyms);
        this.useWord = useWord;
        this.timesAppeared = timesAppeared;
    }

    public int getDaysSinceLastAppeared() {
        return 0;
    }

    public int getTimesAppeared() {
        return timesAppeared;
    }

    public void use(Date now) {
        datesAppeared.add(now);
        
    }
}
