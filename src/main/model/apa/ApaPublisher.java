package model.apa;

import model.SimpleCitationComponent;

// represent the publisher of a work in Apa format
public class ApaPublisher extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaPublisher, with the given Volume
    //          set head to "", and tail to ", "
    public ApaPublisher(String name) {
        super(name, "", ", ");
    }

}
