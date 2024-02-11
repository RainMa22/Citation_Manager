package model.apa;

import model.AuthorName;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;

// represents an author name in APA format
public class ApaAuthorName extends AuthorName {
    public static final int ONE_NAME = 0;
    public static final int LASTNAME_AND_FIRSTNAME = 1;
    public static final int LASTNAME_MIDDLENAME_AND_FIRSTNAME = 2;
    private static final String[] TEMPLATES = {
            "%3$s", //LASTNAME_ONLY
            "%3$s, %1$c.", //LASTNAME_AND_FIRSTNAME
            "%3$s, %1$s. %2$s."// LASTNAME_MIDDLENAME_AND_FIRSTNAME
    };


    private Character firstName;
    private Character middleName;
    private String lastName;

    // constructs the ApaAuthorName class
    // EFFECTS: creates a ApaAuthorName with the given String;
    public ApaAuthorName(String rawString) {
        super();
        this.firstName = '\0';
        this.middleName = '\0';
        this.lastName = "";
        processName(rawString);
    }


    // getter for firstName
    public Character getFirstName() {
        return firstName;
    }

    //getter for middleName
    public Character getMiddleName() {
        return middleName;
    }

    // getter for lastName
    public String getLastName() {
        return lastName;
    }

    // EFFECTS: if middle name is defined: returns "[lastName], [firstName]. [middleName]."
    //          if middle name is empty : "[lastName], [firstName]."
    //          if only lastName is defined: return lastName
    //          if all is empty: returns an empty String.
    @Override
    protected String createBody() {
        String template = TEMPLATES[mode];
        return String.format(template, firstName, middleName, lastName);
    }

    // EFFECTS: splits the given names, delimited by space,
    //          if list is empty, set mode to INACTIVE
    //          if length of list is 1, set list[0] to firstName
    //          if length of the list is 2, set list[0] to firstName, and list[1] to lastName,
    //          if length is >= 3, set uppercase of list[1].charAt(0) to middleName, and list[list.length-1]
    //          to lastName,
    @Override
    protected void processName(String rawString) {
        List<String> words = Arrays.asList(StringUtils.sanitizeString(rawString).split(" "));
        setMode(ONE_NAME);
        this.lastName = words.get(0);
        if (words.size() == 2) {
            setMode(LASTNAME_AND_FIRSTNAME);
            this.firstName = words.get(0).toUpperCase().charAt(0);
            this.lastName = words.get(1);
        } else if (words.size() > 2) {
            setMode(LASTNAME_MIDDLENAME_AND_FIRSTNAME);
            this.firstName = words.get(0).toUpperCase().charAt(0);
            this.middleName = words.get(1).toUpperCase().charAt(0);
            this.lastName = words.get(words.size() - 1);
        }
    }
}
