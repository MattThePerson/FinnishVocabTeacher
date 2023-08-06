import java.util.Date;
import java.util.List;

public class Word {
    
    private String word;
    private String type;
    private String definition;
    private String [] finnishSynonyms;
    private String [] englishSynonyms;

    private Boolean useWord = true;
    private int timesAppeared = 0;
    private List<Date> datesAppeared;
    private String [] previousSentences;

    public Word() {
        //
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String definition){
        this.word = word;
        this.definition = definition;
    }

    public Word(String word, String definition, String[] finnishSynonyms, String[] englishSynonyms, Boolean useWord, int timesAppeared) {
        this.word = word;
        this.useWord = useWord;
        this.timesAppeared = timesAppeared;
    }

    public int getDaysSinceLastAppeared() {
        return 0;
    }

    public void use(Date now) {
        datesAppeared.add(now);
    }
    
    /// GETTERS AND SETTERS ///

    public int getTimesAppeared() {
        return timesAppeared;
    }

    public String getWord() {
        return word;
    }

    public void setFinnishSynonyms(String [] fs) {
        finnishSynonyms = fs;
    }
    public String [] getFinnishSynonyms() {
        return finnishSynonyms;
    }

    public void setEnglishSynonyms(String [] es) {
        englishSynonyms = es;
    }
    public String [] getEnglishSynonyms() {
        return englishSynonyms;
    }

    public void setDefinition(String d) {
        definition = d;
    }
    public String getDefinition() {
        return definition;
    }

    @Override
    public String toString() {
        return word;
    }
}
