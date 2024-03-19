package ui.gui.apa;

import ui.gui.BooleanQuestionField;
import ui.gui.CitationInquiryPanel;
import ui.gui.MultiQuestionField;

/*
 * represents a MLA inquiry panel*/
public class ApaInquiryPanel extends CitationInquiryPanel {
    private static final BooleanQuestionField[] QUESTION_FIELDS = {
            new BooleanQuestionField("Academic?"),
            new BooleanQuestionField("Will Change?")
    };

    // Constructor
    // EFFECTS: creates a new ApaInquiryPanel;
    public ApaInquiryPanel() {
        super();
        formatSelector.getComboBox().setSelectedItem(formats[1]);
    }

    // EFFECTS: returns a new MultiQuestionField with questionFields as parameter
    @Override
    protected MultiQuestionField getMultiBooleanField() {
        return new MultiQuestionField(QUESTION_FIELDS);
    }
}
