package model.apa;

import model.SimpleCitationComponent;
import org.json.JSONObject;

// represent the location(URL/DOI/physical location) of a work in Apa format
public class ApaLocation extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaLocation, with the given Volume
    //          set head to "", and tail to ""
    public ApaLocation(String name) {
        super(name, "", "");
    }

    // constructor
    // EFFECT: create a new ApaLocation, with the given JSONObject
    public ApaLocation(JSONObject json) {
        super(json);
    }

}
