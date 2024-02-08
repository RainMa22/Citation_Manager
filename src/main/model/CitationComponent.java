package model;


/*
 * the ultimate super class for all citation-related classes
 */
public abstract class CitationComponent {
    public static final int INACTIVE = -1;
    protected int mode;
    protected String head;
    protected String tail;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    // constructor for CitationComponent
    // EFFECTS: sets mode to INACTIVE, and head and tail to an empty String;
    public CitationComponent() {
        mode = INACTIVE;
        head = "";
        tail = "";
    }

    // EFFECTS: returns head+createBody()+tail if mode is not INACTIVE, otherwise return an empty String;
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        return head.concat(createBody()).concat(tail);
    }

    protected abstract String createBody();
}
