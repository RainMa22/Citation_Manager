package model.apa;


import model.Citation;
import model.FullCitation;
import model.InvalidCitationError;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// a collection of citations in APA format
public class ApaFullCitation extends FullCitation {
    public static final String FORMAT = "APA";

    // constructor for ApaFullCitation
    // Effects: create an ApaFullCitation with head defined as "<center>References</center>\n" following APA format
    public ApaFullCitation() {
        super();
        this.head = "<center>References</center>\n";
        this.tail = "";
    }

    // alt. constructor for ApaFullCitation
    // REQUIRES: JSONObject.getString("format") is "APA"
    // Effects: create an ApaFullCitation with given JSONObject
    public ApaFullCitation(JSONObject json) {
        super(json);
        JSONArray citationArray = json.getJSONArray("citations");
        for (int i = 0; i < citationArray.length(); i++) {
            citations.add(new ApaCitation(citationArray.getJSONObject(i)));
        }
    }

    // EFFECTS: returns the strings of all citations in citations, joined by newline;
    @Override
    protected String createBody() {
        ArrayList<String> out = new ArrayList<>();
        for (Citation c : citations) {
            out.add(c.toString());
        }
        return String.join("\n", out);
    }

    // MODIFIES: this
    // EFFECTS: Add the citation to the citations treeSet, duplicate citations will be removed
    //          If added Citation is not of type ApaCitation, throw a InvalidCitationError
    //          (because it should not be possible);
    @Override
    public void add(Citation c) throws InvalidCitationError {
        if (!(c instanceof ApaCitation)) {
            throw new InvalidCitationError();
        }
        super.add(c);
    }

    @Override
    public String getFormat() {
        return FORMAT;
    }

}
