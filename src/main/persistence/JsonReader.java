package persistence;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

// Reader for Json files
public class JsonReader {

    private final String filePath;

    //Constructor for JsonReader
    // EFFECTS: create a Json Reader with the given file path
    //          throws FileNotFoundException if file does not exist
    public JsonReader(String filePath) throws FileNotFoundException {
        if (Files.notExists(Path.of(filePath))) {
            throw new FileNotFoundException(filePath + "  not Found!");
        }
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    // EFFECTS: Reads JSON object from the file on filePath
    public JSONObject readJson() {
        Path file = Path.of(filePath);
        StringBuilder builder = new StringBuilder();
        try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
            lines.forEachOrdered(s -> builder.append(s));
        } catch (IOException ioException) {
            return null;
        }
        return new JSONObject(builder.toString());
    }
}
