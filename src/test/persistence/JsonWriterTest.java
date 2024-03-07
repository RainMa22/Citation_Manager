package persistence;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {
    JsonWriter jw;

    String out = "savedCitations/hehe.json";

    @BeforeEach
    public void setUp() {
        try {
            jw = new JsonWriter(out);
        } catch (FileAlreadyExistsException faee) {
            //OK outcome, continue;
        } catch (IOException bad) {
            fail(bad);
        }
    }

    @Test
    public void testConstructor() {
        assertEquals(out, jw.getDestination());
        assertTrue(Files.exists(Path.of(out).getParent()));
        try {
            Files.deleteIfExists(Path.of(out).getParent());
        } catch (IOException e) {
            fail(e);
        }
        setUp();
        assertTrue(Files.exists(Path.of(out).getParent()));
    }

    @Test
    public void testWriteJson() {
        JSONObject json = new JSONObject();
        json.put("hello", "world");
        assertTrue(jw.writeJson(json));
        Path p = Path.of(out);
        try {
            assertEquals(json.toString(), Files.readString(p));
        } catch (IOException e) {
            fail(e);
        }
    }

    @Test
    public void testWriteJsonFalse() {
        try (Stream<Path> paths = Files.list(Path.of(out).getParent())) {
            paths.forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    fail(e);
                }
            });
            Files.deleteIfExists(Path.of(out).getParent());
        } catch (IOException e) {
            fail(e);
        }
        JSONObject json = new JSONObject();
        json.put("hello", "world");
        assertFalse(jw.writeJson(json));

    }
}
