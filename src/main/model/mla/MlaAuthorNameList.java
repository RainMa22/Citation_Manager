package model.mla;

import model.AuthorName;
import model.AuthorNameList;
import model.InvalidFormatException;

import java.util.ArrayList;
import java.util.List;

/*
 * List of AuthorNames under MLA format
 */

public class MlaAuthorNameList implements AuthorNameList {
    private List<AuthorName> names;
    public static final String ERROR = "[ERROR] No names detected! Did you type anything?";

    //Constructor for Mla AuthorNameList
    public MlaAuthorNameList(String rawString) throws InvalidFormatException {
        names = parseString(rawString);
    }

    //getter for names
    @Override
    public List<AuthorName> getNames() {
        return names;
    }

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the MLA format;
    //          throws InvalidFormatException when the list is empty;
    @Override
    public List<AuthorName> parseString(String rawString) throws InvalidFormatException {
        String[] stringNames = rawString.split(",");
        if (stringNames.length == 0) {
            throw new InvalidFormatException(ERROR);
        }
        List<AuthorName> result = new ArrayList<>(stringNames.length);
        for (int i = 0; i < Math.min(stringNames.length, 3); i++) {
            switch (i) {
                case 0:
                    result.add(new MlaAuthorName(stringNames[i], true));
                    break;
                case 1:
                    result.add(new MlaAuthorName(stringNames[i], false));
                    break;
                case 2:
                    result.add(new MlaAuthorName("et al.", false));
                    break;
            }
        }
        return result;
    }

    // EFFECTS: create the citation string for Author block with MLA format
    @Override
    public String toString() {
        return super.toString();
    }
}
