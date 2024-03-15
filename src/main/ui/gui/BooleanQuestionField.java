package ui.gui;

import javax.swing.*;


//Represents a question field that takes String as input;
public class BooleanQuestionField extends QuestionField {
    private final JCheckBox field;

    // Constructor
    // EFFECTS: constructs a BooleanQuestionField with given label and criteria, and 1x1 GridLayout;
    public BooleanQuestionField(String label) {
        super(1, 1);
        this.field = new JCheckBox(label, false);
        field.setHorizontalTextPosition(SwingConstants.CENTER);
        field.setVerticalTextPosition(SwingConstants.TOP);
        setAlignmentX(CENTER_ALIGNMENT);
        add(this.field);
    }

    // EFFECTS: returns user's input from field;
    @Override
    protected String stringValue() {
        return field.getText();
    }

}
