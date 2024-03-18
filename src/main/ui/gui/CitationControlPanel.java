package ui.gui;

import model.Citation;
import model.FullCitation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// represent a panel with plus minus controls and list of
public class CitationControlPanel extends JPanel {
    private AddRemovePanel addRemovePanel;
    private CitationListPanel listPanel;

    //EFFECTS: creates a new Citation control panel
    public CitationControlPanel() {
        addRemovePanel = new AddRemovePanel();
        addRemovePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 10));
        listPanel = new CitationListPanel();
        listPanel.setPreferredSize(new Dimension(getWidth(), getHeight() * 9 / 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(addRemovePanel);
        add(listPanel);
    }

    // EFFECTS: returns the citation from listPanel
    public FullCitation getCitation() {
        return listPanel.getCitation();
    }

    // EFFECTS: sets the full citation of the listPanel
    public void setFullCitation(FullCitation fullCitation) {
        listPanel.setFullCitation(fullCitation);
    }

    // EFFECTS: adds the given Citation to listPanel;
    public void addCitation(Citation citation) {
        listPanel.addCitation(citation);
    }

    // EFFECTS: adds the given action listener to both panels;
    public void addActionListener(ActionListener listener) {
        addRemovePanel.addActionListener(listener);
        listPanel.setListener(listener);
    }

}
