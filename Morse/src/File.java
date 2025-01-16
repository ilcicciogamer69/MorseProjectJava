/**
 * Encrypter and Decrypter of code Morse
 *
 * @author Bryan Ciaponi
 * @version January 2025
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class File {
    private String phrase; // The phrase to handle
    private String morse; // The Morse code to handle
    private int counter; // Counter for iteration
    private String tempString; // Temporary string holder
    private List<String> lines = new ArrayList<>(); // List of lines read from the file
    private Path path = Paths.get(""); // Path to the file
    private boolean status = true; // Status to indicate success or failure

    // Default constructor
    public File() {}

    /**
     * Reads the history file and stores its content in the `lines` list.
     */
    public void readHistory() {
        try {
            lines = Files.readAllLines(path);
            status = true; // Set status to true if the file is read successfully
        } catch (IOException e) {
            System.out.println(
                    "\n-----------------!!!ERROR!!!-----------------" +
                            "\nAn error occurred while trying to read \"history.txt\"." +
                            "\nCheck if \"" + path + "\" exists or is modifiable." +
                            "\nIf you want to use the \"history\" option, you'll have to fix" +
                            "\nthe problem and restart the application." +
                            "\n---------------------------------------------\n"
            );
            status = false; // Set status to false if an error occurs
        }
    }

    /**
     * Returns the current status of file operations.
     * @return true if the operation was successful, false otherwise.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Prints the contents of the history file to the console.
     */
    public void printHistory() {
        for (String line : lines) {
            if (line.equals("-------_______-------_______-------_______-------")) {
                System.out.println(lines.get(counter + 1));
                System.out.println(lines.get(counter + 2));
                System.out.println("");
            }
            counter++;
        }
        counter = 0; // Reset the counter after use
    }

    /**
     * Writes a new entry to the history file.
     * @param phrase The phrase to be saved.
     * @param morse The corresponding Morse code to be saved.
     */
    public void writeHistory(String phrase, String morse) {
        List<String> lines = new ArrayList<>();
        lines.add("\n-------_______-------_______-------_______-------");
        lines.add("Phrase: " + phrase);
        lines.add("Morse: " + morse);
        lines.add("!------_______-------_______-------_______------!");
        try {
            Files.write(path, lines, StandardOpenOption.APPEND); // Append new content to the file
        } catch (IOException ex) {
            System.out.println("Writing error!");
        }
    }

    /**
     * Returns the current file path.
     * @return The current Path object.
     */
    public Path getPath() {
        return path;
    }

    /**
     * Sets the path for the history file.
     * @param pathadd The path to be set.
     */
    public void setPath(String pathadd) {
        try {
            Path tempPath = Paths.get(pathadd);
            this.path = tempPath; // Update the path field
        } catch (InvalidPathException e) { // Handle invalid path exceptions
            System.out.println("Invalid path provided!");
        }
    }

    /**
     * Sets the path for the history file and writes it to the specified file.
     * @param path The file where the path should be written.
     * @param pathadd The new path to be set.
     */
    public void setPath(Path path, String pathadd) {
        try {
            Path tempPath = Paths.get(pathadd);
            this.path = tempPath; // Update the path field
        } catch (InvalidPathException e) { // Handle invalid path exceptions
            System.out.println("Invalid path provided!");
        }

        List<String> lines = new ArrayList<>();
        lines.add(this.path.toString());
        try {
            Files.write(path, lines); // Write the updated path to the file
        } catch (IOException ex) {
            System.out.println("Writing error!");
        }
    }
}
