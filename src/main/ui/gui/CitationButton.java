package ui.gui;

import javax.swing.*;
import java.awt.*;

// represents a Button, which represents a CitationButton
public class CitationButton extends JButton {
    public static final String SELECT_CITATION = "select citation";
    private final GuiCitation citation;

    //EFFECTS: creates a citation button with the given citation
    public CitationButton(GuiCitation citation) {
        super(citation.toString());
        setBackground(null);

        this.citation = citation;
        setActionCommand(SELECT_CITATION);
        setMinimumSize(new Dimension(200, 50));
        setPreferredSize(new Dimension(getWidth(), 100));
    }

    public GuiCitation getCitation() {
        return citation;
    }

    // EFFECTS: selects the Citation Button
    public void select() {
        setBackground(Color.ORANGE);
    }

    // EFFECTS: deselects self
    public void deselect() {
        setBackground(null);
    }
}
