package model.mla;

public class MlaCitationCollection extends MlaCitationTitle {

    //constructor for MlaCitation
    // EFFECTS: creates a MlaCitationTitle with minor set to false
    public MlaCitationCollection(String title) {
        super(title);
        setTail("</i>,");
    }


}
