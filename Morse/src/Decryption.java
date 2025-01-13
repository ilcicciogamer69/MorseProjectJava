import java.util.*;

public class Decryption {
    Map<String, String> dictionary = MorseDictionaryD.MORSE_DICTIONARY; // Dizionario Morse
    private String phrase = ""; // Frase decodificata
    private String tempMorse = ""; // Codice Morse temporaneo

    public Decryption(String morse) {
        this.morse = morse;
    }

    private String morse;

    public String Decrypt() {
        phrase = ""; // Resetta la frase decodificata
        tempMorse = ""; // Resetta il codice temporaneo
        int contatore = 0;

        for (int i = 0; i < morse.length(); i++) {
            char c = morse.charAt(i);

            if (c == '_') {
                // Rileva separatori di parole
                if (i + 1 < morse.length() && morse.charAt(i + 1) == '_') {
                    phrase += " "; // Aggiungi spazio
                    i++;
                }
            } else if (c == '-' || c == '.') {
                // Raccoglie i simboli Morse
                while (i + contatore < morse.length() &&
                        (morse.charAt(i + contatore) == '.' || morse.charAt(i + contatore) == '-')) {
                    tempMorse += morse.charAt(i + contatore);
                    contatore++;
                }

                // Decodifica il simbolo raccolto
                String decoded = dictionary.get(tempMorse);
                if (decoded == null) {
                    phrase += "§"; // Simbolo non riconosciuto
                } else {
                    phrase += decoded;
                }

                // Resetta e aggiorna gli indici
                tempMorse = "";
                i += contatore - 1;
                contatore = 0;
            } else {
                // Gestione di caratteri non Morse
                phrase += c;
            }
        }

        return phrase;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    @Override
    public String toString() {
        return "Decryption{" +
                "morse='" + morse + '\'' +
                '}';
    }
}