package model.mla;

import model.CitationTitle;
import util.StringSanitizer;

public class MlaCitationTitle extends CitationTitle {
    public static final int ACTIVE = 0;
    private boolean minor;

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationTitle(String title) {
        this(title, false);
    }

    // constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to given minor
    public MlaCitationTitle(String title, boolean minor) {
        super(title);
        if (title != null) {
            title = StringSanitizer.sanitizeString(title);
            if (!title.isEmpty()) {
                setMode(ACTIVE);
            }
            setMinor(minor);
        }
    }

    public boolean isMinor() {
        return minor;
    }

    public void setMinor(boolean minor) {
        this.minor = minor;
        if (minor) {
            setHead("\"");
            setTail(".\"");
        } else {
            setHead("<i>");
            setTail("</i>.");
        }
    }

    // EFFECTS: returns title
    @Override
    protected String createBody() {
        return title;
    }

}
