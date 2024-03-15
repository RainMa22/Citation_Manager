package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * tests if a String can be converted into a CitationDate
 */
public class DateCriteria implements IsSatisfiable {
    private static final Pattern PATTERN = Pattern.compile("\\d{4}(-\\d{2}(-\\d{2})?)?");

    // EFFECTS: returns true if string can be made into an active CitationDate.
    @Override
    public boolean isSatisfiedBy(String string) {
        Matcher matcher = PATTERN.matcher(string);
        return matcher.matches();
    }
}
