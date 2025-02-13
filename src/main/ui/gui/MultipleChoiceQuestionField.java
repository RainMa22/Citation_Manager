package ui.gui;

import javax.swing.*;
import java.awt.event.ItemListener;

// represents a multiple choice question of String
public class MultipleChoiceQuestionField extends QuestionField {
    private final JComboBox<String> comboBox;

    //constructor
    // EFFECTS: creates a multiple choice Question Field with the given label and options;
    public MultipleChoiceQuestionField(String label, String[] options) {
        super(2, 1);
        add(new JLabel(label));
        comboBox = new JComboBox<>(options);
        add(comboBox);
        comboBox.setSelectedIndex(0);
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    // EFFECTS: returns the selected String of comboBox
    @Override
    protected String stringValue() {
        return String.valueOf(comboBox.getSelectedItem());
    }

    // EFFECTS: sets field from String Value
    @Override
    public void fromStringValue(String string) {
        comboBox.setSelectedItem(string);
    }

    public void addItemListener(ItemListener listener) {
        comboBox.addItemListener(listener);
    }

}
