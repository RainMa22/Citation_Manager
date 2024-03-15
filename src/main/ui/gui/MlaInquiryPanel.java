package ui.gui;

public class MlaInquiryPanel extends CitationInquiryPanel {
    private static final BooleanQuestionField[] questionFields = {
            new BooleanQuestionField("Minor Work?")};

    public MlaInquiryPanel() {
        super();
        formatSelector.getComboBox().setSelectedItem(formats[0]);
    }

    @Override
    protected MultiQuestionField getMultiBooleanField() {
        return new MultiQuestionField(questionFields);
    }
}
