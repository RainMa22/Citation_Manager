package persistence;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Writer for Json files
public class JsonWriter {
    private final String destination;

    // constructor for JsonWriter
    // EFFECTS: create a JsonWriter instance, if dest's parent folder has not been created, create the parentfolder.
    //          if file already exists, continue
    //          throws IOException if IO errors occurs;
    public JsonWriter(String dest) throws IOException {
        this.destination = dest;
        try {
            Files.createDirectory(Paths.get(dest).getParent());
        } catch (FileAlreadyExistsException acceptable) {
            //acceptable outcome
        }
    }

    public String getDestination() {
        return destination;
    }

    // EFFECTS: writes JSON object to destination
    //          returns false if IOException occurs
    public boolean writeJson(JSONObject json) {
        try {
            Files.writeString(Path.of(destination), json.toString());
            return true;
        } catch (IOException ioException) {
            return false;
        }
    }

}
