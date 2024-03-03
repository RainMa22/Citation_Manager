package model.apa;

import model.SimpleCitationComponent;
import org.json.JSONObject;

// represent the volume number of a work in Apa format
public class ApaVolume extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaVolume, with the given Volume
    //          set head to "", and tail to ""
    public ApaVolume(Integer volume) {
        super(volume, "", "");
    }

    // constructor
    // EFFECT: calls super(JSONObject json)
    public ApaVolume(JSONObject json) {
        super(json);
    }

}
