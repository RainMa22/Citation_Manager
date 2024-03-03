package model.mla;

import model.SimpleCitationComponent;
import org.json.JSONObject;

// represent the location(URL/DOI/physical location) of a work in MLA format
public class MlaLocation extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaLocation, with the given name
    //          set head to "", and tail to ". "
    public MlaLocation(String name) {
        super(name, "", ". ");
    }

    // alt. constructor
    // EFFECT: create a new MlaLocation, with the given JSONObject
    public MlaLocation(JSONObject json) {
        super(json);
    }

}
