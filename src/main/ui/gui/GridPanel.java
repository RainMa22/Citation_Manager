package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// represents a JPanel with gridLayout
public class GridPanel extends JPanel {
    protected int maxLimit;

    // Constructor
    // EFFECTS: creates a grid panel with given rows and Columns
    public GridPanel(int rows, int columns) {
        super();
        maxLimit = rows * columns;
        setLayout(new GridLayout(rows, columns));
    }

    // EFFECTS: adds component to children list before adding it as a GUI Component
    //          if children exceeds max limit, do not add the item and returns null
    @Override
    public Component add(Component field) {
        return add(field, -1);
    }

    // REQUIRES: index >= -1
    // EFFECTS: adds component to children list with the given index before adding it as a GUI Component with the same
    //          index
    //          if children exceeds max limit, do not add the item and returns null
    @Override
    public Component add(Component field, int index) {
        return super.add(field, index);
    }
}
