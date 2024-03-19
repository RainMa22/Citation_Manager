package ui.gui;

import model.Citation;

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
        setMinimumSize(new Dimension(200,100));
        listPanel = new CitationListPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(addRemovePanel);
        add(listPanel);
    }

    // EFFECTS: returns the citation from listPanel
    public FullGuiCitation getCitation() {
        return listPanel.getCitation();
    }

    // EFFECTS: sets the full citation of the listPanel
    public void setFullGuiCitation(FullGuiCitation fullCitation) {
        listPanel.setFullCitation(fullCitation);
    }

    // MODIFIES: this
    // EFFECTS: adds the given Citation to listPanel;
    public void addCitation(Citation citation) {
        listPanel.addCitation(citation);
    }

    // MODIFIES: this
    // EFFECTS: removes the citation from the FullCitation
    public void removeCitation(GuiCitation citation) {
        listPanel.removeCitation(citation);
    }

    // EFFECTS: adds the given action listener to both panels;
    public void addActionListener(ActionListener listener) {
        addRemovePanel.addActionListener(listener);
        listPanel.setListener(listener);
    }

}
