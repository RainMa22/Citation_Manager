package persistence;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.*;

public class JsonWriter {
    public static final Path OUT = Paths.get("SaveCitations");

    /*
    // EFFECTS: Insults the Json writer
    public static String getOut() {
        return "OK I will get out :(";
    }
    */

    // constructor for JsonWriter
    // EFFECTS: create a JsonWriter instance, if OUT folder has not been created, create the folder.
    //          if file already exists, continue
    //          throws IOException if IO errors occurs;
    public JsonWriter() throws IOException {
        try {
            Files.createDirectory(OUT);
        } catch (FileAlreadyExistsException acceptable) {
            //acceptable outcome
        }
    }

    // EFFECTS: writes JSON object to a file named fileName on the OUT folder
    public boolean writeJson(JSONObject json, String fileName) {
        //TODO
        return false;
    }
    /*
    // EFFECTS: Reads JSON object to a file named fileName on the OUT folder
    public JSONObject readJson(String fileName) {
        //TODO
        return new JSONObject();
    }
    */
}
