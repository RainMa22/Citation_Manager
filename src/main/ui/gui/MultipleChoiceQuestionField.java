package ui.gui;

import javax.swing.*;

// represents a multiple choice question of String
public class MultipleChoiceQuestionField extends QuestionField {
    private final JComboBox<String> comboBox;

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    //constructor
    // EFFECTS: creates a multiple choice Question Field with the given label and options;
    //          if options is empty... //TODO
    public MultipleChoiceQuestionField(String label, String[] options) {
        super(2, 1);
        add(new JLabel(label));
        comboBox = new JComboBox<>(options);
        add(comboBox);
        comboBox.setSelectedIndex(0);
    }

    @Override
    protected String stringValue() {
        return String.valueOf(comboBox.getSelectedItem());
    }

    protected int getIndexOfSelected() {
        return comboBox.getSelectedIndex();
    }
}
