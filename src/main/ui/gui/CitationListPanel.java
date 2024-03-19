package ui.gui;

import model.Citation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Set;

//represents the GUI visualization of FullCitaiton
public class CitationListPanel extends GridPanel {
    private FullGuiCitation citation;
    private ActionListener listener;

    // Constructor
    // EFFECTS: constructs an empty citation list panel
    public CitationListPanel() {
        super(0, 1);
        setMinimumSize(new Dimension(100, 200));
        this.citation = null;
    }

    public FullGuiCitation getCitation() {
        return citation;
    }

    // EFFECTS: removes all children, sets citation as given FullCitaiton,
    //          and adds citations as outlined label items into the ListPanel
    public void setFullCitation(FullGuiCitation citation) {
        this.citation = citation;
        update();
    }

    // EFFECTS: updates the citation with the current citation reference;
    public void update() {
        removeAll();
        Set<Citation> citations = citation.getCitations();
        for (Citation c : citations) {
            if (c instanceof GuiCitation) {
                JButton btn = new CitationButton((GuiCitation) c);
                if (listener != null) {
                    btn.addActionListener(listener);
                }
                add(btn);
            }
        }
        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds the citation to the FullCitation
    public void addCitation(Citation citation) {
        this.citation.add(citation);
        update();
    }

    // MODIFIES: this
    // EFFECTS: removes the citation from the FullCitation
    public void removeCitation(GuiCitation citation) {
        this.citation.remove((Citation) citation);
        update();
    }


    public void setListener(ActionListener listener) {
        this.listener = listener;
    }
}
