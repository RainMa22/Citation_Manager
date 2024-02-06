package model;

import java.util.List;

public interface AuthorNameList {
    // getter for AuthorNames
    List<AuthorName> getNames();

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the citation format;
    //          throws InvalidFormatException when the list is empty;
    List<AuthorName> parseString(String rawString) throws InvalidFormatException;

    // EFFECTS: create the citation string for Author block with citation format
    String toString();
}
