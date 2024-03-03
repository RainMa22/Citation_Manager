package model.mla;

import model.SimpleCitationComponent;
import org.json.JSONObject;

// represent the publisher of a work in MLA format
public class MlaPublisher extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaPublisher, with the given name
    //          set head to "", and tail to ", "
    public MlaPublisher(String name) {
        super(name, "", ", ");
    }

    // alt. constructor
    // EFFECT: create a new MlaPublisher, with the given JSONObject
    public MlaPublisher(JSONObject json) {
        super(json);
    }

}
