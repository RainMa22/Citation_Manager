package ui.gui.apa;

import model.apa.ApaCitation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ui.gui.GuiCitation;

import java.util.List;
import java.util.stream.Collectors;

// A subversion of Apa Citation which keeps a version of user input as a JSONArray
public class ApaGuiCitation extends ApaCitation implements GuiCitation {
    private List<String> userInput;

    // EFFECTS: constructs a new ApaGuiCitation, and sets the userInput to the given input
    public ApaGuiCitation(List<String> param) throws IllegalArgumentException {
        super(param);
        param.add(0, "padding");
        userInput = param;
    }

    // EFFECTS: constructs a new ApaGuiCitation, according to the given JSONObject
    //          retrieves "param" from json and set it to user input
    public ApaGuiCitation(JSONObject json) {
        super(json);
        try {
            System.out.println(json.getJSONArray("param"));
            userInput = json.getJSONArray("param").toList().stream().map(Object::toString)
                    .collect(Collectors.toList());
        } catch (JSONException je) {
            userInput = null;
        }
    }

    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();
        out.put("param", new JSONArray(userInput));
        return out;
    }

    public List<String> getUserInput() {
        return userInput;
    }


}
