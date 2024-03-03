package model.apa;

import model.CitationDate;
import org.json.JSONObject;

public class ApaCitationDate extends CitationDate {
    public static final int NO_DATE = 3;
    private boolean academicWork;

    // constructor for CitationDate
    // EFFECTS: constructs a ApaCitationDate with the given dateString and academicWork
    //          if no date generated, set mode to NO_DATE
    //          otherwise, maintain the mode assigned by super
    public ApaCitationDate(String dateString, boolean academicWork) {
        super(dateString);
        this.academicWork = academicWork;
        if (getDate() == null) {
            setMode(NO_DATE);
        }
        super.outputTemplate = new String[]{"yyyy", "yyyy',' MMMMMMM", "yyyy',' MMMMMMM dd"};
        super.setHead("(");
        super.tail = "). ";
    }

    // alt. constructor for CitationDate
    // EFFECTS: constructs a ApaCitationDate with the given JSONObject
    //          set head, tail, mode, output_template and academic work from JSONObject,and parse dateString from it
    //          as well.
    public ApaCitationDate(JSONObject json) {
        super(json);
        this.academicWork = json.getBoolean("academicWork");
        if (getDate() == null) {
            setMode(NO_DATE);
        }
        super.outputTemplate = new String[]{"yyyy", "yyyy',' MMMMMMM", "yyyy',' MMMMMMM dd"};
        super.setHead("(");
        super.tail = "). ";

    }

    //getter for academicWork
    public boolean isAcademicWork() {
        return academicWork;
    }

    //setter for academicWork
    public void setAcademicWork(boolean academicWork) {
        this.academicWork = academicWork;
    }

    // helper function for asJson()
    // EFFECTS: returns the date as a String following the input format, ignores academicWork's override
    //          on the template;
    @Override
    public String getDateString() {
        boolean tempAcademicWork = isAcademicWork();
        setAcademicWork(false);
        String out = super.getDateString();
        setAcademicWork(tempAcademicWork);
        return out;
    }

    // EFFECTS: if there is no date, returns "n.d."
    //          else if academic work, returns year only version of the date
    //          otherwise, returns super.createBody()
    @Override
    public String createBody() {
        if (mode == NO_DATE) {
            return "n.d.";
        } else if (academicWork) {
            int temp = getMode();
            setMode(YEAR_ONLY);
            String out = super.createBody();
            setMode(temp);
            return out;
        }
        return super.createBody();
    }

    // EFFECTS: returns a JSONObject representation of the APACitationDate
    //          saves academicWork into to super.asJson();
    @Override
    public JSONObject asJson() {
        boolean tempAcademicWork = academicWork;
        setAcademicWork(false);
        JSONObject out = super.asJson();
        setAcademicWork(tempAcademicWork);
        out.put("academicWork", academicWork);
        return out;
    }


}
