package ui.gui;

import model.Citation;

import javax.swing.*;
import java.awt.*;

// represents a Button, which represents a CitationButton
public class CitationButton extends JButton {
    public static final String SELECT_CITATION = "select citation";
    private Citation citation;

    //EFFECTS: creates a citation button with the given citation
    public CitationButton(Citation citation) {
        super(citation.toString());
        setBackground(null);

        this.citation = citation;
        setActionCommand(SELECT_CITATION);
        setPreferredSize(new Dimension(getWidth(), 100));
    }

    public Citation getCitation() {
        return citation;
    }

    // EFFECTS: selects the Citation Button
    public void select() {
        setBackground(Color.ORANGE);
        setOpaque(true);
    }

    // EFFECTS: deselects self
    public void deselect() {
        setOpaque(false);
    }
}
