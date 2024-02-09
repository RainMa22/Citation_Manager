package model;

/*
 * tests if a String can be converted into an integer that is the element of [min, max]
 */
public class IntegerCriteria implements IsSatisfiable {
    private final int max;
    private final int min;

    // Constructor for IntegerCriteria
    // EFFECTS: Creates an IntegerCriteria with essentially no max or min limit;
    public IntegerCriteria() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Constructor for IntegerCriteria
    // EFFECTS: Creates an IntegerCriteria with given bounds;
    public IntegerCriteria(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // EFFECTS: if Integer.parseInt(String) is within bounds, return true;
    //          otherwise(including exception thrown) return false
    @Override
    public boolean isSatisfiedBy(String string) {
        try {
            int temp = Integer.parseInt(string);
            return (max >= temp && temp >= min);
        } catch (NumberFormatException ne) {
            return false;
        }
    }
}
