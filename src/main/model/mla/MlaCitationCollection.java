package model.mla;

import model.CitationTitle;

public class MlaCitationCollection extends CitationTitle {

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationCollection(String title) {
        super(title);
    }

    // EFFECTS: return title+"," surronded by double quotation marks if minor is true, otherwise return
    // "<i>"+title+"</i>,"
    @Override
    public String toString() {
        return String.join(title, "<i>", "</i>,");
    }

}
