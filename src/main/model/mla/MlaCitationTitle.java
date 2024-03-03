package model.mla;

import model.CitationTitle;
import org.json.JSONObject;
import util.StringUtils;

// represents a title name in MLA format
public class MlaCitationTitle extends CitationTitle {
    public static final int MINOR = 0;
    public static final int MAJOR = 1;

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationTitle(String title) {
        this(title, false);
    }

    // alt. constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with given JSONObject
    public MlaCitationTitle(JSONObject json) {
        super(json);
    }

    // constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to given minor
    public MlaCitationTitle(String title, boolean minor) {
        super(title);
        if (title != null) {
            title = StringUtils.sanitizeString(title);
            if (!title.isEmpty()) {
                setMinor(minor);
            } else {
                setMode(INACTIVE);
            }
        }
    }

    //EFFECTS: returns true if mode is MINOR else false
    public boolean isMinor() {
        return mode == MINOR;
    }

    // EFFECTS: setMode to MINOR if minor else MAJOR, does nothing if mode is INACTIVE
    public void setMinor(boolean minor) {
        setMode(minor ? MINOR : MAJOR);
    }

    // EFFECTS: sets mode to the given mode,
    //          if mode is MINOR: set head to "\"" and setTail ".\"",
    //          else if mode is MAJOR: set head to "<i>" and tail to "</i>",
    //          does nothing otherwise.
    @Override
    public void setMode(int mode) {
        super.setMode(mode);
        switch (mode) {
            case MINOR:
                setHead("\"");
                setTail(".\" ");
                break;
            case MAJOR:
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
