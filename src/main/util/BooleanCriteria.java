package util;

/*
 * tests if a String can be converted into an integer that is the element of [min, max]
 */
public class BooleanCriteria implements IsSatisfiable {


    // Constructor for BooleanCriteria
    // EFFECTS: Creates an BooleanCriteria;
    public BooleanCriteria() {

    }

    // returns true if BooleanUtils.fromString(string) returns a not-null Boolean; false otherwise;
    @Override
    public boolean isSatisfiedBy(String string) {
        Boolean bool = BooleanUtils.fromString(string);
        return (bool != null);
    }
}
