package model;

/*
 * A simple Citation component that joins head, tail with the toString function of the passed object
 * when toString is called.
 */
public final class SimpleCitationComponent extends CitationComponent {
    private static final int ACTIVE = 0;
    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    // constructor for SimpleCitationComponent
    // EFFECTS: creates a SimpleCitationComponent with the given body, head and tail
    public SimpleCitationComponent(Object body, String head, String tail) {
        super();
        if (body != null) {
            this.body = body;
            this.setMode(ACTIVE);
            this.setHead(head);
            this.setTail(tail);
        }
    }


    // EFFECTS: returns body.toString();
    @Override
    protected String createBody() {
        return body.toString();
    }
}
