package model.apa;

import model.CitationTitle;
import org.json.JSONObject;
import util.StringUtils;

// represents a Citation title in APA format
public class ApaCitationTitle extends CitationTitle {
    public static final int NON_ACADEMIC_WORK = 0;
    public static final int ACADEMIC_WORK = 1;

    //constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with minor set to false
    public ApaCitationTitle(String title) {
        this(title, false);
    }

    // alt. constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with the given JSONObject
    //          set the head, tail, mode, and title to the ones defined in JSONObject
    public ApaCitationTitle(JSONObject json) {
        super(json);
    }

    // constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with minor set to given minor
    public ApaCitationTitle(String title, boolean isAcademicArticle) {
        super(title);
        this.title = StringUtils.sanitizeString(this.title);
        setAcademicArticle(isAcademicArticle);
        if (this.title.isEmpty()) {
            setMode(INACTIVE);
        }
    }

    //EFFECTS: returns if the mode is academic work
    public boolean isAcademicArticle() {
        return mode == ACADEMIC_WORK;
    }

    // MODIFIES: this
    // EFFECTS: set mode to ACADEMIC_WORK if true, NON_ACADEMIC_WORK otherwise
    public void setAcademicArticle(boolean academicArticle) {
        setMode(academicArticle ? ACADEMIC_WORK : NON_ACADEMIC_WORK);
    }

    // EFFECTS: set mode to the given int, mode
    //          if mode is for academic work, set head to "" and tail to ". "
    //          if mode is for non-academic work, set head "<i>", and tail to "</i>."
    //          do nothing otherwise;
    @Override
    public void setMode(int mode) {
        super.setMode(mode);
        switch (mode) {
            case ACADEMIC_WORK:
                setHead("");
                setTail(". ");
                break;
            case NON_ACADEMIC_WORK:
                setHead("<i>");
                setTail("</i>. ");
                break;
            default:
                break;
        }
    }

    // EFFECTS: returns title
    @Override
    protected String createBody() {
        return title;
    }

}
