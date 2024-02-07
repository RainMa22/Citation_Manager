package model.mla;

import model.AuthorName;
import util.StringSanitizer;

import java.util.Arrays;
import java.util.List;

public class MlaAuthorName extends AuthorName {
    private String firstName;
    private Character middleName;
    private String lastName;
    private boolean inverted;

    // constructs the MlaAuthorName class
    // EFFECTS: creates a MlaAuthorName with the given name, with inverted as given;
    public MlaAuthorName(String rawString, boolean inverted) {
        processName(rawString);
        this.inverted = inverted;
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
    //          if middle name is null : [lastName], [firstName] if inverted,
    //                                   [firstName] [lastName] otherwise
    //          if only firstName is defined: return firstName
    @Override
    public String toString() {
        if (middleName == null && lastName == null) {
            return firstName;
        }
        String firstAndMid;
        if (middleName != null) {
            firstAndMid = String.format("%s %c.", firstName, middleName);
        } else {
            firstAndMid = firstName;
        }
        if (isInverted()) {
            return String.format("%2$s, %1$s", firstAndMid, lastName);
        } else {
            return String.join(" ", firstAndMid, lastName);
        }
    }

    // Requires: rawString contains more than just space
    // EFFECTS: splits the given name by space,
    //          if length of the list is 2, set list[0] to firstName, and list[1] to lastName,
    //          if length is >= 3, set uppercase of list[1].charAt(0) to middleName, and list[list.length-1]
    //          to lastName,
    //          throws InvalidFormatException if rawString is empty or is length 1,
    @Override
    protected void processName(String rawString) {
        List<String> words = Arrays.asList(StringSanitizer.sanitizeString(rawString).split(" "));
        this.firstName = words.get(0);
        if (words.size() == 2) {
            this.lastName = words.get(1);
        } else if (words.size() > 2) {
            this.middleName = words.get(1).toUpperCase().charAt(0);
            this.lastName = words.get(words.size() - 1);
        }
    }
}
