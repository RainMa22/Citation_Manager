package model.mla;

import model.CitationDate;

import java.text.SimpleDateFormat;

public class MlaCitationDate extends CitationDate {
    private static final String[] OUTPUT_TEMPLATE = {"yyyy", "MMM yyyy", "dd MMM yyyy"};

    // constructor for CitationDate
    // EFFECTS: constucts a MlaCitationDate with the given dateString
    public MlaCitationDate(String dateString) {
        super(dateString);
    }

    // EFFECTS: if date is undefined, returns an empty String
    //          if only year is specified, return date in the format of "yyyy"
    //          if only Month and year is specified, return date in the format of "MMM yyyy" ("Jan. 1999")
    //          if Day Month and year are all defined, return date in the format of "dd MMM yyyy"("01 Jan. 1999")
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(OUTPUT_TEMPLATE[mode]);
        return dateFormat.format(date);
    }
}
