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
    //          skips the current AuthorName if AuthorName throws invalid format exception.
    @Override
    public List<AuthorName> parseString(String rawString) {
        String[] stringNames = rawString.split(",");
        int target = Math.min(stringNames.length, 3);
        List<AuthorName> result = new ArrayList<>(target);
        int i = 0;
        int padding = 0;
        while (i < target) {
            try {
                int index = i - padding;
                boolean inverted = (index == 0);
                if (index == 2) {
                    result.set(1, new MlaAuthorName("et al", false));
                } else {
                    result.add(new MlaAuthorName(stringNames[i], inverted));
                }
            } catch (InvalidFormatException ife) {
                padding++;
                target = Math.min(stringNames.length, target + 1);
            } finally {
                i++;
            }
        }
        return result;
    }

    // EFFECTS: create the citation string for Author block with MLA format
    //
    @Override
    public String toString() {
        return super.toString();
    }
}
