package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public abstract class AuthorNameList extends CitationComponent {
    protected List<AuthorName> names;

    // EFFECTS: creates an empty authorNameList
    public AuthorNameList() {
        super();
    }

    // EFFECTS: creates an authorNameList with a JSONObject
    public AuthorNameList(JSONObject json) {
        super(json);
    }

    // getter for names
    public List<AuthorName> getNames() {
        return names;
    }

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the citation format;
    //          creates warning if AuthorName throws invalid format exception.
    protected abstract List<AuthorName> parseString(String rawString);

    //EFFECTS: returns a JSON representation of the AuthorNameList
    //         stores head, tail, mode, names(as a JSONArray) into a JSONObject and return it;
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();

        JSONArray nameArray = new JSONArray(getNames());

        out.put("names", nameArray);
        return out;
    }

}
