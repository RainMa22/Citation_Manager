package ui.gui.mla;

import model.mla.MlaCitation;
import org.json.JSONException;
import org.json.JSONObject;
import ui.gui.GuiCitation;

import java.util.List;
import java.util.stream.Collectors;

// A subversion of Mla Citation which keeps a version of user input as a JSONArray
public class MlaGuiCitation extends MlaCitation implements GuiCitation {
    private List<String> userInput;

    // EFFECTS: constructs a new ApaGuiCitation, and sets the userInput to the given input
    public MlaGuiCitation(List<String> param) throws IllegalArgumentException {
        super(param);
        param.add(0, "padding");
        userInput = param;
    }

    // EFFECTS: constructs a new ApaGuiCitation, according to the given JSONObject
    //          retrieves "param" from json and set it to user input
    public MlaGuiCitation(JSONObject json) {
        super(json);
        try {
            userInput = json.getJSONArray("param").toList().stream().map(Object::toString)
                    .collect(Collectors.toList());
        } catch (JSONException je) {
            userInput = null;
        }
    }

    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();
        out.put("param", userInput);
        return out;
    }

    public List<String> getUserInput() {
        return userInput;
    }


}
