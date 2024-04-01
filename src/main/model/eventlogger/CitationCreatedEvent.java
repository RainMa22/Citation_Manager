package model.eventlogger;

import model.Citation;

public class CitationCreatedEvent extends Event {

    private static final String TEMPLATE = "Citation of type %s, and of ID %s created.";


    // EFFECTS: creates a CitationCreatedEvent with the given citation
    //          the event message is "Citation of type {Citation Class Name} and of ID {Citation HashCode}
    //          created.";
    public CitationCreatedEvent(Citation c) {
        super(String.format(TEMPLATE, c.getClass(),c.hashCode()));
    }

}
