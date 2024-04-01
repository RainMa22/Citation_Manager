package model.eventlogger;

import model.Citation;
import model.FullCitation;

public class CitationRemovedEvent extends Event {

    private static final String TEMPLATE = "Citation of type %s(ID %s) is removed from %s(ID %s)";


    // EFFECTS: creates a CitationAddedEvent with the given FullCitation and Citation
    //          the event message is "Citation of type {Citation Class Name}(ID {Citation HashCode})
    //          is removed from {FullCitation Class Name}(ID {Citation Hashcode})";
    public CitationRemovedEvent(FullCitation fullCitation, Citation citation) {
        super(String.format(TEMPLATE, citation.getClass(), citation.hashCode(),
                fullCitation.getClass(), fullCitation.hashCode()));
    }
}
