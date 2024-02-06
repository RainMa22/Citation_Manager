package model.mla;

import model.AuthorName;
import model.InvalidFormatException;

public class MlaAuthorName extends AuthorName {
    public static final String WARNING = "[WARNING] More than three names detected! Using %1$s as the middle name, "
            + "and %2$s as lastname.";
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
        super(rawString);
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
    //          and prints out warning, if it is length > 3.
    @Override
    protected void processName(String rawString) throws InvalidFormatException {
        String[] words = rawString.split(" ");
        if (words.length <= 1) {
            throw new InvalidFormatException(ERROR);
        } else if (words.length == 2) {
            this.firstName = words[0];
            this.lastName = words[1];
        } else if (words.length == 3) {
            this.firstName = words[0];
            this.middleName = words[1].toUpperCase().charAt(0);
            this.lastName = words[2];
        } else {
            this.firstName = words[0];
            this.middleName = words[1].toUpperCase().charAt(0);
            this.lastName = words[words.length - 1];
            System.out.println(String.format(WARNING, middleName, lastName));
        }
    }
}
