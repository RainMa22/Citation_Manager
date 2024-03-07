package persistence;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {
    JsonReader jr;

    String in;
    JSONObject json;

    @BeforeEach
    public void setUp() {
        in = "hehe.json";
        json = new JSONObject("{\"hello\": \"world\"}");
        try {
            Files.writeString(Path.of(in), json.toString());
        } catch (IOException e) {
            fail(e);
        }
        try {
            jr = new JsonReader(in);
        } catch (FileNotFoundException fnfe) {
            fail(fnfe);
        }
    }

    @Test
    public void testConstructor() {
        assertEquals(in, jr.getFilePath());
    }

    @Test
    public void testConsturctorFileNotFound() {
        Path nonExistent = Path.of("dsa.taksd");
        try {
            new JsonReader(nonExistent.toString());
            fail();
        } catch (FileNotFoundException fnfe) {
        }
    }

    @Test
    public void testReadFile() {
        assertEquals(json.toString(), jr.readJson().toString());
    }
}
