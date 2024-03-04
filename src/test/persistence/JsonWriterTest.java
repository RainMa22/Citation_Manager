package persistence;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {
    JsonWriter jw;

    @BeforeEach
    public void setUp() {
        try {
            jw = new JsonWriter();
        } catch (FileAlreadyExistsException faee) {
            //OK outcome, continue;
        } catch (IOException bad) {
            fail(bad);
        }
    }

    @Test
    public void testConstructor() {
        assertTrue(Files.exists(JsonWriter.OUT));
        try {
            Files.deleteIfExists(JsonWriter.OUT);
        } catch (IOException e) {
            fail(e);
        }
        setUp();
        assertTrue(Files.exists(JsonWriter.OUT));
    }

    @Test
    public void testWriteJson() {
        JSONObject json = new JSONObject();
        json.put("hello", "world");
        jw.writeJson(json, "hehe.json");
        Path p = Paths.get("hehe.json");
        try {
            assertEquals(json.toString(), Files.readString(p));
        } catch (IOException e) {
            fail(e);
        }
    }
}
