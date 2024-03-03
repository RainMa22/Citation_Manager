package model.mla;


import org.json.JSONObject;

// Represents An Access Date in MLA format
public class MlaAccessDate extends MlaCitationDate {

    // constructors for MlaAccessDate
    // EFFECTS: create a MlaAccessDate with given dateString
    public MlaAccessDate(String dateString) {
        super(dateString);
        setHead("Accessed ");
        setTail(". ");
    }

    // alt. constructors for MlaAccessDate
    // EFFECTS: create a MlaAccessDate with given JSONObject
    public MlaAccessDate(JSONObject json) {
        super(json);
    }
}
