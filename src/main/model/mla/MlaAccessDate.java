package model.mla;


// Represents An Access Date in MLA format
public class MlaAccessDate extends MlaCitationDate {

    // constructors for MlaAccessDate
    // EFFECTS: create a MlaAccessDate with given dateString
    public MlaAccessDate(String dateString) {
        super(dateString);
        setHead("Accessed ");
        setTail(". ");
    }

}
