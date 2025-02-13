package model;


import model.eventlogger.EventLog;
import org.json.JSONObject;
import persistence.AsJsonable;

/*
 * the ultimate super class for all citation-related classes
 */
public abstract class CitationComponent implements AsJsonable {
    public static final int INACTIVE = -1;
    protected int mode;
    protected String head;
    protected String tail;
    protected EventLog log;

    // constructor for CitationComponent
    // EFFECTS: sets mode to INACTIVE, and head and tail to an empty String;
    //          and set log to the Eventlog Instance;
    public CitationComponent() {
        mode = INACTIVE;
        head = "";
        tail = "";
        log = EventLog.getInstance();
    }

    // alternate constructor for CitationComponent
    // EFFECTS: receives head, tail and mode from passed JSONObject;
    //          and set log to the Eventlog Instance;
    public CitationComponent(JSONObject json) {
        this();
        mode = json.getInt("mode");
        head = json.getString("head");
        tail = json.getString("tail");
    }

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

    // EFFECTS: returns head+createBody()+tail if mode is not INACTIVE, otherwise return an empty String;
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        return head.concat(createBody()).concat(tail);
    }

    //EFFECTS: a function that returns the body String
    protected abstract String createBody();

    //EFFECTS: returns a JSONObject representation of self
    @Override
    public JSONObject asJson() {
        JSONObject out = new JSONObject();
        out.put("head", getHead());
        out.put("tail", getTail());
        out.put("mode", getMode());
        return out;
    }
}
