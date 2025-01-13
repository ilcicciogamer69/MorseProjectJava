import java.util.*;

public class Encryption {
    Map<String, String> dictionary = MorseDictionaryE.MORSE_DICTIONARY;
    private String phrase = "";
    private String morse = "";



    public Encryption(String phrase) {
        this.phrase = phrase;
    }

    public String Encrypt() {
        for(int i = 0; i < phrase.length(); i++){
            char c = Character.toLowerCase(phrase.charAt(i));
            if (c == ' '){
                morse += "__";
            }
            else if (dictionary.containsKey(String.valueOf(c))) {
                morse += dictionary.get(String.valueOf(c));
                if (i < (phrase.length() - 1) && phrase.charAt(i+1) != ' '){
                    morse += "_";
                }
            }
            else {
                morse += c;
            }
        }
        return morse;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return "Encryption{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}
