package model.mla;

// Represent a collection name in MLA format
public class MlaCitationCollection extends MlaCitationTitle {

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationCollection(String title) {
        super(title);
        setTail("</i>, ");
    }


}
