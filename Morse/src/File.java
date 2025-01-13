import java.io.*;
import java.nio.file.*;
import java.util.*;

public class File {
    private String phrase;
    private String morse;
    private List<String> lines = new ArrayList<>();
    private Path path = Paths.get("./src/history.txt");
    private boolean status = true;


    public File(){}

    public void readHistory() {
        try{
            lines = Files.readAllLines(path);
            status = true;
        }catch(IOException e){
            System.out.println(
                    "\n-----------------!!!ERROR!!!-----------------" +
                    "\nAn error occurred in trying reading \"history.txt\"." +
                    "\nCheck if \"" + path + "\" exists or is modifiable." +
                    "\nIf you want to use the \"history\" option you'll have to fix" +
                    "\nthe problem and restart the application." +
                    "\n---------------------------------------------\n"
            );
            status = false;
        }
    }

    public boolean getStatus(){
        return status;
    }

    public void printHistory(){
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void writeHistory() {

    }

    public Path getPath(){
        return path;
    }

    public void setPath(String path) {
        try {
            Path tempPath = Paths.get(path);
            this.path = tempPath;   // Aggiorna il campo path
        } catch (InvalidPathException e) {  // Gestione di percorsi non validi
            System.out.println("Invalid path provided!");
        }
    }
}