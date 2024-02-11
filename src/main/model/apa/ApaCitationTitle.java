package model.apa;

import model.CitationTitle;
import util.StringUtils;

public class ApaCitationTitle extends CitationTitle {
    public static final int ACTIVE = 0;
    private boolean minor;

    //constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with minor set to false
    public ApaCitationTitle(String title) {
        this(title, false);
    }

    // constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with minor set to given minor
    public ApaCitationTitle(String title, boolean minor) {
        super(title);
        if (title != null) {
            title = StringUtils.sanitizeString(title);
            setMinor(minor);
            if (!title.isEmpty()) {
                setMode(ACTIVE);
            } else {
                setMode(INACTIVE);
            }
        }
    }

    public boolean isMinor() {
        return minor;
    }

    public void setMinor(boolean minor) {
        this.minor = minor;
        if (minor) {
            setHead("\"");
            setTail(".\" ");
        } else {
            setHead("<i>");
            setTail("</i>. ");
        }
    }

    // EFFECTS: returns title
    @Override
    protected String createBody() {
        return title;
    }

}
