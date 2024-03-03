package model.apa;

import model.SimpleCitationComponent;
import org.json.JSONObject;

// represent the issue Name of a work in APA format
public class ApaIssueName extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaIssueName, with the given Volume
    //          set head to "(", and tail to ). "
    public ApaIssueName(String name) {
        super(name, "(", "). ");
    }

    // alt. constructor
    // EFFECT: create a new ApaIssueName, with the given JSON object
    public ApaIssueName(JSONObject json) {
        super(json);
    }
}

