package model.mla;

import model.SimpleCitationComponent;

// represent the location(URL/DOI/physical location) of a work in MLA format
public class MlaLocation extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaLocation, with the given Volume
    //          set head to "", and tail to ". "
    public MlaLocation(String name) {
        super(name, "", ". ");
    }

}
