package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// represents a JPanel with gridLayout
public class GridPanel extends JPanel {
    protected List<Component> children;

    // Constructor
    // EFFECTS: creates a grid panel with given rows and Columns
    public GridPanel(int rows, int columns) {
        super();
        children = new LinkedList<>();
        setLayout(new GridLayout(rows, columns));
    }

    // EFFECTS: adds component to children list before adding it as a GUI Component
    @Override
    public Component add(Component field) {
        children.add(field);
        return super.add(field);
    }

    // EFFECTS: adds component to children list with the given index before adding it as a GUI Component with the same
    //          index
    @Override
    public Component add(Component field, int index) {
        children.add(index, field);
        return super.add(field, index);
    }
}
