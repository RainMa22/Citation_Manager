package ui.gui;

import model.Citation;
import model.FullCitation;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

//represents the GUI visualization of FullCitaiton
public class CitationListPanel extends GridPanel {
    private FullCitation citation;
    private JScrollPane scrollPane;

    // Constructor
    // EFFECTS: constructs an empty citation list panel
    public CitationListPanel() {
        super(0, 1);
        scrollPane = new JScrollPane();
        setMinimumSize(new Dimension(100, 200));
        //setLayout(new ScrollPaneLayout());
        this.citation = null;
        //scrollPane.setSize(getWidth(),getHeight());
        add(scrollPane);
//      setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//      setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
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
//s        setSize(getWidth(), 100 * citations.size());
        for (Citation c : citations) {
            JButton btn = new JButton(c.toString());
            btn.setPreferredSize(new Dimension(getWidth(), 100));
            add(btn);
//            scrollPane.add(btn);
        }
        revalidate();
//        scrollPane.revalidate();
    }


    // helper function for update
    // EFFECTS: adds the citation as a JLabel to the Citation
    public void addCitation(Citation citation) {
        this.citation.add(citation);
        System.out.println(this.citation);
        update();
    }
}
