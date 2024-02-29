package model;

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

    //getter for Citations
    public TreeSet<Citation> getCitations() {
        return citations;
    }

    // MODIFIES: this
    // EFFECTS: Add the citation to the citations treeSet, duplicate citations will be removed
    public void add(Citation c) {
        citations.add(c);
    }

    public abstract String getFormat();

    // EFFECTS: returns a JSONObject representation of the FullCitation
    //          stores head, tail, mode, format, citations as a JSONArray;
    @Override
    public JSONObject asJson() {
        JSONObject out = new JSONObject();
        out.put("head", getHead());
        out.put("tail", getTail());
        out.put("mode", getMode());
        out.put("format", getFormat());
        out.put("citations", new JSONArray(citations));
        return out;
    }
}
