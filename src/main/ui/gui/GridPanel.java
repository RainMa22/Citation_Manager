package ui.gui;

import javax.swing.*;
import java.awt.*;

// represents a JPanel with gridLayout
public class GridPanel extends JPanel {
    // Constructor
    // EFFECTS: creates a grid panel with given rows and Columns
    public GridPanel(int rows, int columns) {
        super();
        setLayout(new GridLayout(rows, columns));
    }
}
