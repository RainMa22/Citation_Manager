package ui.gui;

import model.DateCriteria;
import model.DummyCriteria;
import model.IntegerCriteria;
import model.IsSatisfiable;

//represents a panel for citation-based Inquiries
public abstract class CitationInquiryPanel extends GridPanel {
    protected static final String[] formats = {"MLA", "APA"};
    protected static final IsSatisfiable[] CRITERIAS = {
            new DummyCriteria(), new DummyCriteria(), new DummyCriteria(), new DummyCriteria(), new DummyCriteria(),
            new IntegerCriteria(), new DummyCriteria(), new DateCriteria(), new DummyCriteria(), new DateCriteria(),
            new DummyCriteria(),
    };
    private static final String INSERT_BOOLEAN_HERE = "THIS SHOULD NOT BE DISPLAYED!";
    protected static final String[] PARAMETERS = {
            "Format", "Author Name", "Title", INSERT_BOOLEAN_HERE, "Collection", "volume", "Issue Name",
            "Publish Date(yyyy[-mm[-dd]])", "Publisher", "Access Date(yyyy[-mm[-dd]])", "Location(URL, DOI, etc.)"
    };
    protected MultipleChoiceQuestionField formatSelector;

    // Constructor
    // Creates a CitationInquiryPanel based on the given available formats
    public CitationInquiryPanel() {
        super(4, 3);
        formatSelector = new MultipleChoiceQuestionField(PARAMETERS[0], formats);
        add(formatSelector);
        for (int i = 1; i < PARAMETERS.length; i++) {
            String parameter = PARAMETERS[i];
            if (parameter.equals(INSERT_BOOLEAN_HERE)) {
                add(getMultiBooleanField());
                continue;
            }
            add(new TextQuestionField(parameter, CRITERIAS[i]));
        }

    }

    protected abstract MultiQuestionField getMultiBooleanField();
}
