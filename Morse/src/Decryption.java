/**
 * Encrypter and Decrypter of code Morse
 *
 * @author Bryan Ciaponi
 * @version January 2025
 */

import java.util.*;

public class Decryption {
    private Map<String, String> dictionary = MorseDictionaryD.MORSE_DICTIONARY; // Morse dictionary for decoding
    private String phrase = ""; // Decoded phrase
    private String tempMorse = ""; // Temporary Morse code holder
    private String morse; // Input Morse code

    // Constructor to initialize the Morse code for decryption
    public Decryption(String morse) {
        this.morse = morse;
    }

    /**
     * Method to decrypt the provided Morse code into a phrase.
     * @return The decoded phrase.
     */
    public String Decrypt() {
        phrase = ""; // Reset the decoded phrase
        tempMorse = ""; // Reset the temporary Morse code holder
        int contatore = 0;

        // Loop through the Morse code
        for (int i = 0; i < morse.length(); i++) {
            char c = morse.charAt(i);

            if (c == '_') {
                // Detect word separators
                if (i + 1 < morse.length() && morse.charAt(i + 1) == '_') {
                    phrase += " "; // Add a space for word separation
                    i++; // Skip the second underscore
                }
            } else if (c == '-' || c == '.') {
                // Collect Morse symbols
                while (i + contatore < morse.length() &&
                        (morse.charAt(i + contatore) == '.' || morse.charAt(i + contatore) == '-')) {
                    tempMorse += morse.charAt(i + contatore);
                    contatore++;
                }

                // Decode the collected Morse symbol
                String decoded = dictionary.get(tempMorse);
                if (decoded == null) {
                    phrase += "§"; // Add a placeholder for unrecognized symbols
                } else {
                    phrase += decoded; // Add the decoded character
                }

                // Reset the temporary Morse code holder and update indices
                tempMorse = "";
                i += contatore - 1; // Adjust the loop index to account for processed symbols
                contatore = 0; // Reset the counter
            } else {
                // Handle non-Morse characters
                phrase += c; // Add the character directly to the phrase
            }
        }

        return phrase;
    }

    // Getter for the Morse code
    public String getMorse() {
        return morse;
    }

    // Setter for the Morse code
    public void setMorse(String morse) {
        this.morse = morse;
    }

    // Getter for the decoded phrase
    public String getPhrase() {
        return phrase;
    }

    @Override
    public String toString() {
        return "Decryption{" +
                "morse='" + morse + '\'' +
                '}';
    }
}
