package model;

import java.util.List;

public interface AuthorNameList {
    // getter for AuthorNames
    List<AuthorName> getNames();

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the citation format;
    //          creates warning if AuthorName throws invalid format exception.
    List<AuthorName> parseString(String rawString);

    // EFFECTS: create the citation string for Author block with citation format
    String toString();
}
