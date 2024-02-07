package model.mla;

import model.AuthorName;
import model.InvalidFormatException;

import java.util.Arrays;
import java.util.List;

public class MlaAuthorName extends AuthorName {
    public static final String INVERTED_TEMPLATE = "%3$s, %1$s %2$s";
    public static final String NORMAL_TEMPLATE = "%1$s %2$s %3$s";
    public static final String ERROR = "[ERROR] Typed name has only one word! Did you put in the full name?";
    private String firstName;
    private Character middleName;
    private String lastName;
    private boolean inverted;

    // constructs the MlaAuthorName class
    // EFFECTS: creates a MlaAuthorName with the given name, with inverted as given;
    public MlaAuthorName(String rawString, boolean inverted) throws InvalidFormatException {
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
    @Override
    public String toString() {
        String output;
        String middleClause;

        if (middleName == null) {
            middleClause = "";
        } else {
            middleClause = middleName + ".";
        }

        if (this.isInverted()) {
            output = String.format(INVERTED_TEMPLATE, firstName, middleClause, lastName);
        } else {
            output = String.format(NORMAL_TEMPLATE, firstName, middleClause, lastName);
        }
        return output.trim();
    }

    // EFFECTS: splits the given name by space,
    //          if length of the list is 2, set list[0] to firstName, and list[1] to lastName,
    //          if length is >= 3, set uppercase of list[1].charAt(0) to middleName, and list[list.length-1]
    //          to lastName,
    //          throws InvalidFormatException if rawString is empty or is length 1,
    @Override
    protected void processName(String rawString) throws InvalidFormatException {
        List<String> words = Arrays.asList(rawString.trim().split(" "));
        if (words.size() <= 1) {
            throw new InvalidFormatException(ERROR);
        } else {
            this.firstName = words.get(0);
            if (words.size() == 2) {
                this.lastName = words.get(1);
            } else {
                this.middleName = words.get(1).toUpperCase().charAt(0);
                this.lastName = words.get(words.size() - 1);
            }
        }
    }
}
