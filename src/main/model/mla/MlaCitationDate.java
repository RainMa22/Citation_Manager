package model.mla;

import model.CitationDate;

public class MlaCitationDate extends CitationDate {

    // constructor for CitationDate
    // EFFECTS: constucts a MlaCitationDate with the given dateString
    public MlaCitationDate(String dateString) {
        super(dateString);
        super.outputTemplate = new String[]{"yyyy", "MMM yyyy", "dd MMM yyyy"};
        super.tail = ",";
    }

}
