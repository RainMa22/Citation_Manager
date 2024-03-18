package ui.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

//represents the menu bar of the gui
public class CitationMenuBar extends JMenuBar {
    public static final String SAVE_CITATION = "save citation";
    public static final String EXPORT_CITATION = "export citation";
    private final JMenu file;
    private JMenuItem save;
    private JMenuItem export;

    // EFFECTS: construct a new Citation menu bar
    public CitationMenuBar() {
        file = new JMenu("File");
        save = new JMenuItem("Save as HTML");
        save.setActionCommand(SAVE_CITATION);
        export = new JMenuItem("Export to Json");
        export.setActionCommand(EXPORT_CITATION);

        file.add(save);
        file.add(export);

        add(file);
    }

    // EFFECTS: adds the given action listener to all the child buttons;
    public void addActionListener(ActionListener listener) {
        save.addActionListener(listener);
        export.addActionListener(listener);
    }
}
