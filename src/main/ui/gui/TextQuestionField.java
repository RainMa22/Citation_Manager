package ui.gui;

import model.IsSatisfiable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Represents a question field that takes String as input;
public class TextQuestionField extends QuestionField implements KeyListener {
    private final JLabel label;
    private final JTextField field;
    private final IsSatisfiable criteria;
    private final JLabel error;

    // Constructor
    // EFFECTS: constructs a TextQuestionField with given label and criteria, and 1x3 GridLayout;
    public TextQuestionField(String label, IsSatisfiable criteria) {
        super(1, 3);
        this.label = new JLabel(label);
        this.label.setAlignmentX(LEFT_ALIGNMENT);
        this.field = new JTextField(1);
        this.criteria = criteria;
        this.error = new JLabel();
        error.setForeground(Color.RED);
        add(this.label);
        add(this.field);
        add(this.error);
        addKeyListener(this);
    }

    // EFFECTS: returns user's input from field;
    @Override
    String getStringVal() {
        return field.getText();
    }

    // EFFECTS: on key typed, evaluate whether the user input is valid,
    // if invalid, set text of error label to "Invalid Input!"
    // otherwise, clear the error label
    @Override
    public void keyTyped(KeyEvent e) {
        if (!criteria.isSatisfiedBy(getStringVal())) {
            this.error.setText("Invalid Input!");
        } else {
            this.error.setText("");
        }
    }

    // EFFECTS: nothing
    @Override
    public void keyPressed(KeyEvent e) {
        //nothing
    }

    // EFFECTS: nothing
    @Override
    public void keyReleased(KeyEvent e) {
        //nothing
    }
}
