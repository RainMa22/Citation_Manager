package ui.gui;

public abstract class QuestionField extends GridPanel implements HasStringValue {
    // Constructor
    // EFFECTS: constructs a question field with a gridlayout with given rows and columns
    public QuestionField(int rows, int columns) {
        super(rows, columns);
    }

    // EFFECTS: returns user's input as String if not disabled();
    //          returns empty String otherwise
    @Override
    public String getStringVal() {
        if (!this.isEnabled()) {
            return "";
        } else {
            return stringValue();
        }
    }

    protected abstract String stringValue();
}
