package model.mla;

import model.CitationDate;

public class MlaCitationDate extends CitationDate {
    public static final int ACTIVE = 0;

    // constructor for CitationDate
    // EFFECTS: constructs a MlaCitationDate with the given dateString
    public MlaCitationDate(String dateString) {
        super(dateString);
        if (getDate() != null) {
            setMode(ACTIVE);
            super.outputTemplate = new String[]{"yyyy", "MMM yyyy", "dd MMM yyyy"};
            super.tail = ",";
        }
    }


}
