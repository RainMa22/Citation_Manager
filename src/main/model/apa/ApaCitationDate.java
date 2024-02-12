package model.apa;

import model.CitationDate;

public class ApaCitationDate extends CitationDate {
    public static final int NO_DATE = 3;
    private final boolean academicWork;

    // constructor for CitationDate
    // EFFECTS: constructs a ApaCitationDate with the given dateString,
    //          if noDateGenerated, set mode to NO_DATE
    //          else if academicWork, set mode to YEAR_ONLY
    //          otherwise, maintain the mode assigned by super
    public ApaCitationDate(String dateString, boolean academicWork) {
        super(dateString);
        this.academicWork = academicWork;
        if (getDate() == null) {
            setMode(NO_DATE);
        } else if (academicWork) {
            setMode(YEAR_ONLY);
        }
        super.outputTemplate = new String[]{"yyyy", "yyyy',' MMMMMMM", "yyyy',' MMMMMMM dd"};
        super.setHead("(");
        super.tail = "). ";

    }
    
    // EFFECTS: if there is no date, returns "n.d."
    //          otherwise, returns super.createBody()
    @Override
    public String createBody() {
        if (mode == NO_DATE) {
            return "n.d.";
        }
        return super.createBody();
    }


}
