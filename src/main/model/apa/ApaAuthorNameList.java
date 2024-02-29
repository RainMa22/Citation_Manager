package model.apa;

import model.AuthorName;
import model.AuthorNameList;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * List of AuthorNames under APA format
 */

public class ApaAuthorNameList extends AuthorNameList {
    public static final int ONE_NAME = 0;
    public static final int MULTIPLE_NAME = 1;
    public static final int MORE_THAN_TWENTY_NAMES = 2;

    //Constructor for ApaAuthorNameList
    public ApaAuthorNameList(String rawString) {
        super();
        names = parseString(rawString);
        this.setTail(" ");
    }

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the Apa format;
    //          if rawString is empty, return null;
    @Override
    public List<AuthorName> parseString(String rawString) {
        if (rawString == null) {
            return null;
        }
        rawString = StringUtils.sanitizeString(rawString);
        if (rawString.isEmpty()) {
            return null;
        }
        List<AuthorName> result = new ArrayList<>(1);
        String[] stringNames = rawString.split(",");
        result.add(new ApaAuthorName(stringNames[0]));
        if (stringNames.length == 1) {
            setMode(ONE_NAME);
        } else {
            setMode(MULTIPLE_NAME);
            for (int i = 1; i < Math.min(stringNames.length, 21); i++) {
                result.add(new ApaAuthorName(stringNames[i]));
                if (i == 20) {
                    setMode(MORE_THAN_TWENTY_NAMES);
                    result.set(19, new ApaAuthorName(stringNames[i]));
                }
            }
        }
        return result;
    }

    // EFFECTS: create the citation sentence(excluding period) for Author block with Apa format
    //          if no names stored, returns an empty String
    @Override
    protected String createBody() {
        String out;
        Stream<String> nameStrings;
        switch (mode) {
            case ONE_NAME:
            default:
                out = names.get(0).toString();
                break;
            case MULTIPLE_NAME:
                int length = names.size();
                nameStrings = names.subList(0, length - 1).stream().map(AuthorName::toString);
                out = String.join(", ", nameStrings.collect(Collectors.toList()));
                out = String.join(", & ", out, names.get(length - 1).toString());
                break;
            case MORE_THAN_TWENTY_NAMES:
                nameStrings = names.subList(0, 19).stream().map(AuthorName::toString);
                out = String.join(", ", nameStrings.collect(Collectors.toList()));
                out = String.join(", ... ", out, names.get(names.size() - 1).toString());
                break;
        }
        return out;
    }
}
