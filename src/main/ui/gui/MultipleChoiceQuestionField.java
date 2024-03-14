package ui.gui;

import javax.swing.*;

// represents a multiple choice question of String
public class MultipleChoiceQuestionField extends QuestionField {
    private final JComboBox<String> comboBox;

    public MultipleChoiceQuestionField(String label, String[] options) {
        super(2, 1);
        add(new JLabel(label));
        comboBox = new JComboBox<>(options);
        add(comboBox);
    }

    @Override
    protected String stringValue() {
        return String.valueOf(comboBox.getSelectedItem());
    }
}
