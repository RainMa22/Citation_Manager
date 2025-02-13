package model.mla;

import model.AuthorName;
import model.AuthorNameList;
import org.json.JSONArray;
import org.json.JSONObject;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * List of AuthorNames under MLA format
 */

public class MlaAuthorNameList extends AuthorNameList {
    public static final int ONE_NAME = 0;
    public static final int TWO_NAME = 1;
    public static final int ET_AL = 2;

    // Constructor for Mla AuthorNameList
    // EFFECTS: creates one MlaAuthorNameList from the given rawString
    public MlaAuthorNameList(String rawString) {
        super();
        names = parseString(rawString);
        super.setTail(". ");
    }

    // alt. Constructor for Mla AuthorNameList
    // EFFECTS: creates one MlaAuthorNameList from the given JSONObject
    public MlaAuthorNameList(JSONObject json) {
        super(json);
        JSONArray names = json.getJSONArray("names");
        this.names = new ArrayList<>(names.length());
        for (int i = 0; i < names.length(); i++) {
            this.names.add(new MlaAuthorName(names.getJSONObject(i)));
        }
    }

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the MLA format;
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

        List<AuthorName> result = new ArrayList<>(2);
        setMode(ONE_NAME);
        String[] stringNames = rawString.split(",");
        int target = stringNames.length;
        result.add(new MlaAuthorName(stringNames[0], true));
        if (target == 2) {
            setMode(TWO_NAME);
            if (stringNames[1].trim().startsWith("et")) {
                setMode(ET_AL);
            }
            result.add(new MlaAuthorName(stringNames[1], false));
        } else if (target > 2) {
            setMode(ET_AL);
            result.add(new MlaAuthorName("et al", false));
        }
        return result;
    }

    // EFFECTS: create the citation sentence(excluding period) for Author block with MLA format
    //          if no names stored, returns an empty String
    @Override
    protected String createBody() {
        String out;
        switch (mode) {
            case ONE_NAME:
                out = names.get(0).toString();
                break;
            case TWO_NAME:
                out = String.join(", and ", names.get(0).toString(), names.get(1).toString());
                break;
            case ET_AL:
            default:
                out = String.join(", ", names.get(0).toString(), names.get(1).toString());
                break;
        }
        return StringUtils.removeTailing(out, ".");
    }
}
