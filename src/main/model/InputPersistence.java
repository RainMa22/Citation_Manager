package model;

import org.json.JSONObject;

import java.util.List;

// Anything that remembers its creation parameter.
public interface InputPersistence {
    JSONObject asJson();

    List<String> getUserInput();
}
