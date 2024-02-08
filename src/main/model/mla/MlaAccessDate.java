package model.mla;

public class MlaAccessDate extends MlaCitationDate {
    public MlaAccessDate(String dateString) {
        super(dateString);
    }

    // returns "accessed "+ super.toString() unless mode is INACTIVE;
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        return "accessed ".concat(super.toString());
    }
}
