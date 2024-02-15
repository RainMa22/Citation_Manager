package model.apa;

import model.SimpleCitationComponent;

// represent the volume number of a work in Apa format
public class ApaVolume extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaVolume, with the given Volume
    //          set head to "", and tail to ""
    public ApaVolume(Integer volume) {
        super(volume, "", "");
    }

}
