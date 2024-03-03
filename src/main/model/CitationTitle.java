package model;

import org.json.JSONObject;

/*
 * The title of a Citation in a citation, usually a name of the book or the article title.*/
public abstract class CitationTitle extends CitationComponent {
    protected String title;

    // constuctor for CitationTitle
    // EFFECTS: creates CitationTitle with the given title
    public CitationTitle(String title) {
        super();
        this.title = (title == null ? "" : title);
    }

    // alt. constuctor for CitationTitle
    // EFFECTS: creates CitationTitle with the given JSONObject
    public CitationTitle(JSONObject json) {
        super(json);
        this.title = json.getString("title");
    }

    public String getTitle() {
        return title;
    }

    //EFFECTS: returns the JSONObject representation of the Citation,
    //         stores head, tail, mode, and title into a JSONObject and returns it;
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();
        out.put("title", title);
        return out;
    }


}
