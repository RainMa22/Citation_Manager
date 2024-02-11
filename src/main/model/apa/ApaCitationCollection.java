package model.apa;

public class ApaCitationCollection extends ApaCitationTitle {

    //constructor for ApaCitation
    // EFFECTS: creates a ApaCitationTitle with minor set to false
    public ApaCitationCollection(String title) {
        super(title);
        setTail("</i>, ");
    }


}
