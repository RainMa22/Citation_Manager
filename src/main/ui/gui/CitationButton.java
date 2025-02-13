package ui.gui;

import model.Citation;

import javax.swing.*;
import java.awt.*;

// represents a Button, which has a reference to a Citation
public class CitationButton extends JButton {
    public static final String SELECT_CITATION = "select citation";
    private final Citation citation;

    //EFFECTS: creates a citation button with the given citation
    public CitationButton(Citation citation) {
        super(citation.toString());
        setBackground(null);

        this.citation = citation;
        setActionCommand(SELECT_CITATION);
        setMinimumSize(new Dimension(200, 50));
        setPreferredSize(new Dimension(getWidth(), 100));
    }

    public Citation getCitation() {
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
