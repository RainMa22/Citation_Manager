package ui.gui.mla;

import model.Citation;
import model.error.InvalidCitationError;
import model.mla.MlaFullCitation;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.gui.FullGuiCitation;

// A subversion of Mla Citation which uses MlaGuiCitation
public class MlaFullGuiCitation extends MlaFullCitation implements FullGuiCitation {

    // EFFECTS: constructs a new MlaFullGuiCitation
    public MlaFullGuiCitation() {
        super();
    }

    // EFFECTS: constructs a new ApaGuiCitation, according to the given JSONObject
    //          retrieves "param" from json and set it to user input
    public MlaFullGuiCitation(JSONObject json) {
        super();
        JSONArray citationArray = json.getJSONArray("citations");
        for (int i = 0; i < citationArray.length(); i++) {
            citations.add(new MlaGuiCitation(citationArray.getJSONObject(i)));
        }
    }

    @Override
    public void add(Citation c) {
        if (!(c instanceof MlaGuiCitation)) {
            throw new InvalidCitationError();
        }
        super.add(c);
    }
}
