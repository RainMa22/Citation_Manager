package ui.gui;

import model.Citation;
import model.FullCitation;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

//represents the GUI visualization of FullCitaiton
public class CitationListPanel extends JScrollPane {
    FullCitation citation;

    // Constructor
    // EFFECTS: constructs an empty citation list panel
    public CitationListPanel() {
        super();
        setMinimumSize(new Dimension(100, 100));
        setLayout(new ScrollPaneLayout());
        this.citation = null;
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    // EFFECTS: removes all children, sets citation as given FullCitaiton,
    //          and adds citations as outlined label items into the ListPanel
    public void setFullCitation(FullCitation citation) {
        this.citation = citation;
        update();
    }

    // EFFECTS: updates the citation with the current citation reference;
    public void update() {
        removeAll();
        Set<Citation> citations = citation.getCitations();
        for (Citation c : citations) {
            addCitation(c);
        }
        setMinimumSize(new Dimension(100, 200));
    }


    // helper function for update
    // EFFECTS: adds the citation as a JLabel to the Citation
    public void addCitation(Citation citation) {
        JButton btn = new JButton(citation.toString());
        add(btn);
        this.citation.add(citation);
        revalidate();
    }
}
