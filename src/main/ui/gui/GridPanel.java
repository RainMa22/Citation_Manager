package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// represents a JPanel with gridLayout
public class GridPanel extends JPanel {

    // Constructor
    // EFFECTS: creates a grid panel with given rows and Columns
    public GridPanel(int rows, int columns) {
        super();
        setLayout(new GridLayout(rows, columns));
    }

    // EFFECTS: adds component to children list before adding it as a GUI Component
    @Override
    public Component add(Component field) {
        return add(field, -1);
    }

    // REQUIRES: getComponents().length > index >= -1
    // EFFECTS: adds component to children list with the given index before adding it as a GUI Component with the same
    //          index
    //          if index is -1, adds the component to the last of the list
    @Override
    public Component add(Component field, int index) {
        return super.add(field, index);
    }
}
