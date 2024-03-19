package ui.gui.apa;

import model.Citation;
import model.apa.ApaFullCitation;
import model.error.InvalidCitationError;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.gui.FullGuiCitation;

// A subversion of Apa Citation which uses ApaGuiCitation
public class ApaFullGuiCitation extends ApaFullCitation implements FullGuiCitation {

    // EFFECTS: constructs a new ApaFullGuiCitation
    public ApaFullGuiCitation() {
        super();
    }

    // EFFECTS: constructs a new ApaGuiCitation, according to the given JSONObject
    //          retrieves "param" from json and set it to user input
    public ApaFullGuiCitation(JSONObject json) {
        super();
        JSONArray citationArray = json.getJSONArray("citations");
        for (int i = 0; i < citationArray.length(); i++) {
            citations.add(new ApaGuiCitation(citationArray.getJSONObject(i)));
        }
    }

    @Override
    public void add(Citation c) {
        if (!(c instanceof ApaGuiCitation)) {
            throw new InvalidCitationError();
        }
        super.add(c);
    }
}
