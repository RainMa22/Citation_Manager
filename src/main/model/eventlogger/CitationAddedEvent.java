package model.eventlogger;

import model.Citation;
import model.FullCitation;

public class CitationAddedEvent extends Event {

    private static final String TEMPLATE = "Citation of type %s(ID %s) is added to %s(ID %s)";


    // EFFECTS: creates a CitationAddedEvent with the given FullCitation and Citation
    //          the event message is "Citation of type {Citation Class Name}(ID {Citation HashCode})
    //          is added to {FullCitation Class Name}(ID {Citation Hashcode})";
    public CitationAddedEvent(FullCitation fullCitation, Citation citation) {
        super(String.format(TEMPLATE, citation.getClass(), citation.hashCode(),
                fullCitation.getClass(), fullCitation.hashCode()));
    }
}
