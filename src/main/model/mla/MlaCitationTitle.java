package model.mla;

import model.CitationTitle;

public class MlaCitationTitle extends CitationTitle {
    private boolean minor;

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationTitle(String title) {
        this(title, false);
    }

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to given minor
    public MlaCitationTitle(String title, boolean minor) {
        super(title);
        this.minor = minor;
    }

    public boolean isMinor() {
        return minor;
    }

    // EFFECTS: return title+"." surronded by double quotation marks if minor is true, otherwise return
    // "<i>"+title+"</i>."
    @Override
    public String toString() {
        if (this.minor) {
            return String.join(title, "\"", ".\"");
        }
        return String.join(title, "<i>", "</i>.");
    }

}
