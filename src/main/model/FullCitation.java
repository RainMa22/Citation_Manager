package model;

import model.eventlogger.CitationAddedEvent;
import model.eventlogger.CitationRemovedEvent;
import model.eventlogger.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.TreeSet;

// represent a full citation of a given citing format
public abstract class FullCitation extends CitationComponent {
    public static final int ACTIVE = 0;
    protected TreeSet<Citation> citations;

    // Constructor for FullCitation
    // EFFECTS: Set Mode to ACTIVE and initialize the citations to sort citation by name in ascending order
    public FullCitation() {
        this.mode = ACTIVE;
        citations = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Citation o1, Citation o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    // alt. Constructor for FullCitation
    // EFFECTS: copies head, tail, and mode from the JSON object, and
    //          initialize the citations to sort citation by name in ascending order
    public FullCitation(JSONObject json) {
        super(json);
        citations = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Citation o1, Citation o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    //getter for Citations
    public TreeSet<Citation> getCitations() {
        return citations;
    }

    // MODIFIES: this
    // EFFECTS: Add the citation to the citations treeSet, duplicate citations will be removed
    public void add(Citation c) {
        citations.add(c);
    }

    // REQUIRES: citation has been added to the list of citations
    // EFFECTS: logs the added citation to the event log
    public CitationAddedEvent logAddition(Citation c) {
        CitationAddedEvent addedEvent = new CitationAddedEvent(this, c);
        EventLog.getInstance().logEvent(addedEvent);
        return addedEvent;
    }

    // REQUIRES: citation c has been removed from the list of citations
    // EFFECTS: logs the added citation to the event log
    public CitationRemovedEvent logRemoval(Citation c) {
        CitationRemovedEvent removedEvent = new CitationRemovedEvent(this, c);
        EventLog.getInstance().logEvent(removedEvent);
        return removedEvent;
    }

    // MODIFIES: this
    // EFFECTS: remove the citation from the citations treeSet.
    public void remove(Citation c) {
        citations.remove(c);
    }

    public abstract String getFormat();

    // EFFECTS: returns a JSONObject representation of the FullCitation
    //          stores head, tail, mode, format, citations as a JSONArray;
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();
        out.put("format", getFormat());
        out.put("citations", new JSONArray(citations.stream().map(Citation::asJson).toArray()));
        return out;
    }
}
