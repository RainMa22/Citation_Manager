package model;

/*
 * A dummy IsSatisfiable, where isSatisfiedBy always return true
 */
public class DummyCriteria implements IsSatisfiable {
    // EFFECTS: always returns true
    @Override
    public boolean isSatisfiedBy(String string) {
        return true;
    }
}
