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
        if (body != null && !body.toString().isEmpty()) {
            this.setMode(ACTIVE);
        }
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
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
        if (getBody() == null) {
            out.put("body", "");
        } else {
            out.put("body", getBody().toString());
        }
        return out;
    }
}
