/**
 * Encrypter and Decrypter of code Morse
 *
 * @author Bryan Ciaponi
 * @version January 2025
 */

import java.util.*;


public class Encryption {
    // A dictionary mapping characters to Morse code.
    private Map<String, String> dictionary = MorseDictionaryE.MORSE_DICTIONARY;
    // The original phrase to be encrypted.
    private String phrase = "";
    // The resulting Morse code after encryption.
    private String morse = "";

    /**
     * Constructor that initializes the Encryption object with a given phrase.
     * @param phrase The phrase to be encrypted into Morse code.
     */
    public Encryption(String phrase) {
        this.phrase = phrase;
    }

    /**
     * Encrypts the phrase into Morse code.
     * Each character in the phrase is converted based on the dictionary.
     * Spaces are represented as double underscores (__), and Morse symbols are separated by underscores (_).
     * If a character is not found in the dictionary, it is added to the Morse code output as-is.
     * @return The resulting Morse code string.
     */
    public String Encrypt() {
        for (int i = 0; i < phrase.length(); i++) {
            char c = Character.toLowerCase(phrase.charAt(i)); // Convert character to lowercase for consistency.

            if (c == ' ') {
                // Represent spaces in the phrase as double underscores.
                morse += "__";
            } else if (dictionary.containsKey(String.valueOf(c))) {
                // If the character exists in the dictionary, add its Morse code equivalent.
                morse += dictionary.get(String.valueOf(c));
                // Add a single underscore separator unless it is the last character or the next character is a space.
                if (i < (phrase.length() - 1) && phrase.charAt(i + 1) != ' ') {
                    morse += "_";
                }
            } else {
                // If the character is not found in the dictionary, add it to the output as-is.
                morse += c;
            }
        }
        return morse;
    }

    /**
     * Retrieves the original phrase to be encrypted.
     * @return The original phrase.
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * Updates the phrase to be encrypted.
     * @param phrase The new phrase to set.
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * Retrieves the resulting Morse code after encryption.
     * @return The Morse code string.
     */
    public String getMorse() {
        return morse;
    }

    /**
     * Provides a string representation of the Encryption object.
     * @return A string representation of the object showing the phrase.
     */
    @Override
    public String toString() {
        return "Encryption{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}
