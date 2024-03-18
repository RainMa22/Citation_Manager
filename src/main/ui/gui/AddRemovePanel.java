package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A Panel with add/remove button
public class AddRemovePanel extends JPanel {
    public static final String ADD_NEW = "Add new";
    public static final String REMOVE_SELECTED = "remove selected";

    private JButton plus;
    private JButton minus;

    // EFFECTS: construct a AddRemovePanel using flow layout, set plus to a JButton labelled "+" with action
    //          command set to ADD_NEW, and set minus to "-" with action command REMOVE_SELECTED
    public AddRemovePanel() {
        super();
        plus = new JButton("+");
        plus.setActionCommand(ADD_NEW);
        minus = new JButton("-");
        minus.setActionCommand(REMOVE_SELECTED);
        setLayout(new FlowLayout());
        add(plus);
        add(minus);
    }


    // EFFECTS: adds the given actionListener to add/remove button
    public void addActionListener(ActionListener listener) {
        plus.addActionListener(listener);
        minus.addActionListener(listener);
    }

}
