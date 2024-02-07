package model.mla;

import model.AuthorName;
import util.StringSanitizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MlaAuthorName extends AuthorName {
    public static final int INACTIVE = -1;
    public static final int FIRSTNAME_ONLY = 0;
    public static final int FIRSTNAME_AND_LASTNAME = 1;
    public static final int FIRSTNAME_MIDDLENAME_AND_LASTNAME = 2;
    private static final String[][] FORMAT_FRAGMENTS = {
            new String[]{"%1$s"}, //FIRSTNAME_ONLY
            new String[]{"%1$s", "%3$s"}, //FIRSTNAME_AND_LASTNAME
            new String[]{"%1$s %2$c.", "%3$s"} // FIRSTNAME_MIDDLENAME_AND_LASTNAME
    };


    private String firstName;
    private Character middleName;
    private String lastName;
    private boolean inverted;
    private int mode;

    // constructs the MlaAuthorName class
    // EFFECTS: creates a MlaAuthorName with the given String, with inverted as given;
    public MlaAuthorName(String rawString, boolean inverted) {
        this.firstName = "";
        this.middleName = '\0';
        this.lastName = "";
        processName(rawString);
        this.inverted = inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public int getMode() {
        return mode;
    }

    // getter for inverted
    public boolean isInverted() {
        return inverted;
    }

    // getter for firstName
    public String getFirstName() {
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

    // EFFECTS: if middle name is defined: returns "[lastName], [firstName] [middleName]." if inverted,
    //                                      otherwise, returns "[firstName] [middleName]. [lastName]"
    //          if middle name is empty : [lastName], [firstName] if inverted,
    //                                   [firstName] [lastName] otherwise
    //          if only firstName is defined: return firstName
    //          if all is empty: returns an empty String.
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        List<String> fragments = Arrays.asList(FORMAT_FRAGMENTS[mode].clone());
        String template;
        if (isInverted()) {
            Collections.reverse(fragments);
            template = String.join(", ", fragments);
        } else {
            template = String.join(" ", fragments);
        }
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
        List<String> words = Arrays.asList(StringSanitizer.sanitizeString(rawString).split(" "));
        mode = INACTIVE;
        if (words.isEmpty()) {
            return;
        }
        mode = FIRSTNAME_ONLY;
        this.firstName = words.get(0);
        if (words.size() == 2) {
            mode = FIRSTNAME_AND_LASTNAME;
            this.lastName = words.get(1);
        } else if (words.size() > 2) {
            mode = FIRSTNAME_MIDDLENAME_AND_LASTNAME;
            this.middleName = words.get(1).toUpperCase().charAt(0);
            this.lastName = words.get(words.size() - 1);
        }
    }
}
