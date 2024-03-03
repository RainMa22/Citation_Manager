package model.apa;

import org.json.JSONObject;

public class ApaCitationCollection extends ApaCitationTitle {

    // constructor for ApaCitation
    // EFFECTS: creates a ApaCitationCollection with given title
    public ApaCitationCollection(String title) {
        super(title);
        setTail("</i>, ");
    }

    // alt. constructor for ApaCitation
    // EFFECTS: creates a ApaCitationCollection with given JSONObject
    //          get head, tail, mode, and title from the JSONObject
    public ApaCitationCollection(JSONObject json) {
        super(json);
    }


}
