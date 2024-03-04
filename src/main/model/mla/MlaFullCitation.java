package model.mla;


import model.Citation;
import model.FullCitation;
import model.InvalidCitationError;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// a collection of citations in MLA format
public class MlaFullCitation extends FullCitation {

    public static final String FORMAT = "MLA";

    // constructor for MlaFullCitation
    // Effects: create an MlaFullCitation with head defined as "<center>References</center>\n" following Mla format
    public MlaFullCitation() {
        super();
        this.head = "<center>Work Cited</center>\n";
        this.tail = "";
    }

    // alt. constructor for MlaFullCitation
    // REQUIRES: json.getString("format").equals("MLA")
    // Effects: create an MlaFullCitation with the given JSONObject
    public MlaFullCitation(JSONObject json) {
        super(json);
        JSONArray citationArray = json.getJSONArray("citations");
        for (int i = 0; i < citationArray.length(); i++) {
            citations.add(new MlaCitation(citationArray.getJSONObject(i)));
        }
    }

    // EFFECTS: returns the strings of all citations in citations, joined by newline;
    //          set the authorName to ---. on the second(or more) consecutive citations with the same author
    @Override
    protected String createBody() {
        ArrayList<String> out = new ArrayList<>();
        String prevAuthorNames = "\0";
        for (Citation c : citations) {
            String citationString = c.toString();
            if (citationString.startsWith(prevAuthorNames)) {
                citationString = citationString.replaceFirst(prevAuthorNames, "---. ");
            } else {
                prevAuthorNames = c.getAuthorNames().toString();
            }
            out.add(citationString);
        }
        return String.join("\n", out);
    }

    // MODIFIES: this
    // EFFECTS: Add the citation to the citations treeSet, duplicate citations will be removed
    //          If added Citation is not of type MlaCitation, throw a InvalidCitationError
    //          (because it should not be possible);
    @Override
    public void add(Citation c) throws InvalidCitationError {
        if (!(c instanceof MlaCitation)) {
            throw new InvalidCitationError();
        }
        super.add(c);
    }

    @Override
    public String getFormat() {
        return FORMAT;
    }

}
