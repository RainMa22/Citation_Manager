package model.mla;

import model.SimpleCitationComponent;

// represent the publisher of a work in MLA format
public class MlaPublisher extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaPublisher, with the given Volume
    //          set head to "", and tail to ", "
    public MlaPublisher(String name) {
        super(name, "", ", ");
    }

}
