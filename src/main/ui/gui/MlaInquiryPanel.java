package ui.gui;

/*
 * represents a MLA inquiry panel*/
public class MlaInquiryPanel extends CitationInquiryPanel {
    private static final BooleanQuestionField[] QUESTION_FIELDS = {
            new BooleanQuestionField("Minor Work?")
    };

    // Constructor
    // EFFECTS: creates a new MLAInquiryPanel;
    public MlaInquiryPanel() {
        super();
        formatSelector.getComboBox().setSelectedItem(formats[0]);
    }

    // EFFECTS: returns a new MultiQuestionField with questionFields as parameter
    @Override
    protected MultiQuestionField getMultiBooleanField() {
        return new MultiQuestionField(QUESTION_FIELDS);
    }
}
