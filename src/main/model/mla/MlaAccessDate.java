package model.mla;

public class MlaAccessDate extends MlaCitationDate {

    public MlaAccessDate(String dateString) {
        super(dateString);
        setHead("Accessed ");
        setTail(". ");
    }

}
