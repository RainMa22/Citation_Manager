package model;

import org.json.JSONObject;

/*
 * A simple Citation component that joins head, tail with the toString function of the passed object
 * when toString is called.
 */
public class SimpleCitationComponent extends CitationComponent {
    public static final int ACTIVE = 0;
    private Object body;

    // constructor for SimpleCitationComponent
    // EFFECTS: creates a SimpleCitationComponent with the given body, head and tail
    public SimpleCitationComponent(Object body, String head, String tail) {
        super();
        this.setBody(body);
        this.setHead(head);
        this.setTail(tail);
        if (!getBody().toString().isEmpty()) {
            this.setMode(ACTIVE);
        }
    }

    // alternate constructor for SimpleCitationComponent
    // EFFECTS: creates a SimpleCitationComponent with the given body, head, mode and tail from a JSONObject
    public SimpleCitationComponent(JSONObject json) {
        super(json);
        setBody(json.get("body"));
    }

    public Object getBody() {
        return body;
    }

    // MODIFIES: this
    // EFFECT: sets the body to the given body, if body is null, set body to "";
    public void setBody(Object body) {
        this.body = body == null ? "" : body;
    }

    // EFFECTS: returns body.toString();
    @Override
    protected String createBody() {
        return body.toString();
    }

    //EFFECTS: returns the JSONObject representation of self
    //         stores head, tail, mode and body, which is needed to replicate the citation
    //         if body is null, store the body as ""
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();
        out.put("body", getBody().toString());
        return out;
    }
}
