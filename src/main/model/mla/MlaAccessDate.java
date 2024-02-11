package model.mla;


// Respresents An MlaAccessDate
public class MlaAccessDate extends MlaCitationDate {

    // constructors for MlaAccessDate
    // EFFECTS: create a MlaAccessDate with given dateString
    public MlaAccessDate(String dateString) {
        super(dateString);
        setHead("Accessed ");
        setTail(". ");
    }

}
