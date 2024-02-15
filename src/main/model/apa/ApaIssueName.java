package model.apa;

import model.SimpleCitationComponent;

// represent the issue Name of a work in APA format
public class ApaIssueName extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new ApaIssueName, with the given Volume
    //          set head to "(", and tail to ). "
    public ApaIssueName(String name) {
        super(name, "(", "). ");
    }

}
