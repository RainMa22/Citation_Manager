package model.mla;

import model.SimpleCitationComponent;

// represent the volume number of a work in MLA format
public class MlaVolume extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaVolume, with the given Volume
    //          set head to "vol. ", and tail to ", "
    public MlaVolume(Integer volume) {
        super(volume, "vol.", ", ");
    }

}
