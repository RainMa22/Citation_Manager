package ui.gui;

public class MlaInquiryPanel extends CitationInquiryPanel {
    public MlaInquiryPanel() {
        super();
        children.get(0);
    }

    @Override
    protected MultiQuestionField getMultiBooleanField() {
        return null;
    }
}
