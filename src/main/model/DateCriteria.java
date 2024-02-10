package model;

/*
 * tests if a String can be converted into a CitationDate
 */
public class DateCriteria implements IsSatisfiable {

    // EFFECTS: returns true if string can be made into an active CitationDate.
    @Override
    public boolean isSatisfiedBy(String string) {
        return new MockCitationDate(string).getMode() != MockCitationDate.INACTIVE;
    }

    /*
     * A CitationDate that can be initialized
     */
    private static class MockCitationDate extends CitationDate {

        public MockCitationDate(String dateString) {
            super(dateString);
        }
    }
}
