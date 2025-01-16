/**
 * Encrypter and Decrypter of code Morse
 *
 * @author Bryan Ciaponi
 * @version January 2025
 */

import java.util.*;

// Method on how to make a Dictionary public in Java from Stack Overflow
public class MorseDictionaryD {
    // Declaration of a public static and final map (or "Dictionary" in Python)
    // This map cannot be modified after initialization
    public static final Map<String, String> MORSE_DICTIONARY;

    static {
        // Initialize the map
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put(".-", "a");
        tempMap.put("-...", "b");
        tempMap.put("-.-.", "c");
        tempMap.put("-..", "d");
        tempMap.put(".", "e");
        tempMap.put("..-.", "f");
        tempMap.put("--.", "g");
        tempMap.put("....", "h");
        tempMap.put("..", "i");
        tempMap.put(".---", "j");
        tempMap.put("-.-", "k");
        tempMap.put(".-..", "l");
        tempMap.put("--", "m");
        tempMap.put("-.", "n");
        tempMap.put("---", "o");
        tempMap.put(".--.", "p");
        tempMap.put("--.-", "q");
        tempMap.put(".-.", "r");
        tempMap.put("...", "s");
        tempMap.put("-", "t");
        tempMap.put("..-", "u");
        tempMap.put("...-", "v");
        tempMap.put(".--", "w");
        tempMap.put("-..-", "x");
        tempMap.put("-.--", "y");
        tempMap.put("--..", "z");
        tempMap.put(".----", "1");
        tempMap.put("..---", "2");
        tempMap.put("...--", "3");
        tempMap.put("....-", "4");
        tempMap.put(".....", "5");
        tempMap.put("-....", "6");
        tempMap.put("--...", "7");
        tempMap.put("---..", "8");
        tempMap.put("----.", "9");
        tempMap.put("-----", "0");
        tempMap.put("--..--", ",");
        tempMap.put(".-.-.-", ".");
        tempMap.put("..--..", "?");
        tempMap.put("-.-.--", "!");
        tempMap.put("-.-.-", ";");
        tempMap.put("---...", ":");
        tempMap.put("-..-.", "/");
        tempMap.put("-....-", "-");
        tempMap.put(".----.", "'");
        tempMap.put("-.--.", "(");
        tempMap.put("-.--.-", ")");
        tempMap.put("..--.-", "_");
        tempMap.put(".--.-.", "@");
        tempMap.put(".-...", "&");
        tempMap.put("-...-", "=");
        tempMap.put(".-.-.", "+");
        tempMap.put(".-..-.", "\"");
        tempMap.put("...-..-", "$");
        tempMap.put(".....-", "#");
        tempMap.put("-..-..", "*");
        tempMap.put("..--", "ù");
        tempMap.put("---.", "ò");
        tempMap.put(".---.", "ì");
        tempMap.put("..-..", "é");
        tempMap.put(".-..-", "è");
        tempMap.put(".--.-", "à");

        // Make the map immutable (it cannot be modified after this point)
        MORSE_DICTIONARY = Collections.unmodifiableMap(tempMap);
    }
}
