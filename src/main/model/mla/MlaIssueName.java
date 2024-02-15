package model.mla;

import model.SimpleCitationComponent;

// represent the issue Name of a work in MLA format
public class MlaIssueName extends SimpleCitationComponent {

    // constructor
    // EFFECT: create a new MlaIssueName, with the given Volume
    //          set head to "", and tail to ", "
    public MlaIssueName(String name) {
        super(name, "", ", ");
    }

}
