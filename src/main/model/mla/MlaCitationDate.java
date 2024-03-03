package model.mla;

import model.CitationDate;
import org.json.JSONObject;

// Represents a citation date in MLA format
public class MlaCitationDate extends CitationDate {

    // constructor for CitationDate
    // EFFECTS: constructs a MlaCitationDate with the given dateString
    public MlaCitationDate(String dateString) {
        super(dateString);
        if (getDate() != null) {
            super.outputTemplate = new String[]{"yyyy", "MMM yyyy", "dd MMM yyyy"};
            super.tail = ", ";
        }
    }

    // alt. constructor for CitationDate
    // EFFECTS: constructs a MlaCitationDate with the given JSONObject
    public MlaCitationDate(JSONObject json) {
        super(json);
    }


}
