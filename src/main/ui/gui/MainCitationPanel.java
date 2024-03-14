package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//represents the main citation inquiry JPanel
public class MainCitationPanel extends JPanel {
    //constructor
    // EFFECTS: constructs a new MainCitationPanel, adding the contents as content;
    public MainCitationPanel(List<JComponent> contents) {
        super();
        setMinimumSize(new Dimension(200, contents.size() / 2 * 100));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (JComponent component : contents) {
            add(component);
        }
    }
}
