package model.apa;

import model.CitationDate;
import org.json.JSONObject;

// Represents An ApaAccessDate
public class ApaAccessDate extends CitationDate {

    // constructors for ApaAccessDate
    // EFFECTS: create a ApaAccessDate with given dateString
    public ApaAccessDate(String dateString) {
        super(dateString);
        super.head = "Retrieved ";
        if (getDate() != null) {
            super.outputTemplate = new String[]{"yyyy", "MMMMMMM yyyy", "MMMMMMM dd',' yyyy"};
            super.tail = ", from ";
        }
    }

    // alternate constructors for ApaAccessDate
    // EFFECTS: create a ApaAccessDate with given JSONObject
    public ApaAccessDate(JSONObject json) {
        super(json);
    }
}
