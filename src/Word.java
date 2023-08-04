public class Word {
    
    private String word;
    private String type;
    private String definition;
    private String [] finnishSynonyms;
    private String [] englishSynonyms;

    public Word(String w, String d, String[] fs, String[] es) {
        word = w;
        definition = d;
    }

    //// GETTERS ////

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public String [] getFinnishSynonyms() {
        return finnishSynonyms;
    }
    
    public String [] getEnglishSynonyms() {
        return englishSynonyms;
    }

    //// SETTERS ////

    public void setDefinition(String d) {
        definition = d;
    }

    public void setFinnishSynonyms(String [] s) {
        finnishSynonyms = s;
    }

    public void setEnglishSynonyms(String [] s) {
        englishSynonyms = s;
    }
}
