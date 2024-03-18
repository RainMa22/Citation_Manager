package ui.gui;

import model.IsSatisfiable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Represents a question field that takes String as input;
public class TextQuestionField extends QuestionField implements KeyListener {
    private final JTextField field;
    private final IsSatisfiable criteria;
    private final JLabel error;

    // Constructor
    // EFFECTS: constructs a TextQuestionField with given label and criteria, and 1x3 GridLayout;
    public TextQuestionField(String label, IsSatisfiable criteria) {
        super(3, 1);
        JLabel label1 = new JLabel(label);
        label1.setAlignmentX(LEFT_ALIGNMENT);
        this.field = new JTextField(1);
        this.criteria = criteria;
        this.error = new JLabel();
        error.setForeground(Color.RED);
        add(label1);
        add(this.field);
        add(this.error);
        field.addKeyListener(this);
    }

    // EFFECTS: returns user's input from field;
    @Override
    protected String stringValue() {
        return field.getText();
    }

    // EFFECTS: sets field from String Value
    @Override
    public void fromStringValue(String string) {
        field.setText(string);
    }

    // EFFECTS: nothing
    @Override
    public void keyTyped(KeyEvent e) {
        //nothing
    }

    // EFFECTS: nothing
    @Override
    public void keyPressed(KeyEvent e) {
        //nothing
    }

    // EFFECTS: on key typed, evaluate whether the user input is valid,
    // if invalid, set text of error label to "Invalid Input!"
    // otherwise, clear the error label
    @Override
    public void keyReleased(KeyEvent e) {
        if (!criteria.isSatisfiedBy(stringValue())) {
            this.error.setText("Invalid Input!");
        } else {
            this.error.setText("");
        }
    }
}
