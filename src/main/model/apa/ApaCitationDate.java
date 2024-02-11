package model.apa;

import model.CitationDate;

public class ApaCitationDate extends CitationDate {

    // constructor for CitationDate
    // EFFECTS: constructs a ApaCitationDate with the given dateString
    public ApaCitationDate(String dateString) {
        super(dateString);
        if (getDate() != null) {
            super.outputTemplate = new String[]{"yyyy", "MMM yyyy", "dd MMM yyyy"};
            super.tail = ", ";
        }
    }


}
