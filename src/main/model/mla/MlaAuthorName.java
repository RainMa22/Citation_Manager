package model.mla;

import model.AuthorName;
import model.InvalidFormatException;

public class MlaAuthorName extends AuthorName {
    private String firstName;
    private Character middleName;
    private String lastName;
    boolean inverted;

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

    //getter for lastName
    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return null;
    }

    // EFFECTS: splits the given name by space,
    //          if length of the list is 2, set list[0] to firstName, and list[1] to lastName,
    //          if length is >= 3, set uppercase of list[1].charAt(0) to middleName, and list[2] to lastName,
    //          throws InvalidFormatException if rawString is empty or is length 1,
    //          and prints out warning, if it is length > 3.
    @Override
    protected void processName(String rawString) throws InvalidFormatException {
//        [firstName] [middleName] [lastName]
    }
}
