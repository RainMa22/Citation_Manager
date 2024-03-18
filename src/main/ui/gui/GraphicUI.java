package ui.gui;

import model.FullCitation;
import model.apa.ApaCitation;
import model.apa.ApaFullCitation;
import model.mla.MlaCitation;
import model.mla.MlaFullCitation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/*
 * Class representing the GUI Frame of the Citation Generator
 * */
public class GraphicUI extends JFrame implements ActionListener, ItemListener {
    private static final String[] formats = {"MLA", "APA"};
    private static final String TITLE = "Citation Generator";
    private static final String COMMAND_CONFIRM = "submit";
    private static final int USE_MLA = 0;
    private static final int USE_APA = 1;

    private JButton confirm;

    private CitationInquiryPanel citationInquiries;
    private JSplitPane splitPane;
    private CitationControlPanel controlPanel;
    private int mode;
    private CitationButton selected;

    //Constructor
    // EFFECTS: constructs the GUI for citation generation
    public GraphicUI() {
        super(TITLE);
        selected = null;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        splitPane = new JSplitPane();
        controlPanel = new CitationControlPanel();
        splitPane.setRightComponent(controlPanel);
        add(splitPane);
        pack();
        splitPane.setDividerLocation(.8);
        setMode(USE_MLA);
        controlPanel.addActionListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    // EFFECTS: creates a new GraphicUI
    public static void main(String[] args) {
        new GraphicUI();
    }

    // EFFECTS: set the current mode to the given mode
    public void setMode(int mode) {
        this.mode = mode;
        resetInquiry();

        FullCitation fullCitation = mode == USE_MLA ? new MlaFullCitation() : new ApaFullCitation();
        setCitationInquiries(citationInquiries);
        controlPanel.setFullCitation(fullCitation);
        splitPane.setRightComponent(controlPanel);
    }

    // EFFECTS: removes the old citation inquire panel and add the new one;
    private void setCitationInquiries(CitationInquiryPanel panel) {
        panel.getFormatSelector().addItemListener(this);
        panel.add(confirm);
        splitPane.setLeftComponent(panel);
    }

    // EFFECT: This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case COMMAND_CONFIRM:
                List<String> param = citationInquiries.getStringListVal();
                param = param.subList(1, param.size());
                System.out.println(param);
                removeSelected();
                controlPanel.addCitation(mode == USE_MLA ? new MlaCitation(param) : new ApaCitation(param));
                resetInquiry();
                break;
            case AddRemovePanel.ADD_NEW:
                clearSelection();
                resetInquiry();
                break;
            case AddRemovePanel.REMOVE_SELECTED:
                removeSelected();
                break;
            case CitationButton.SELECT_CITATION:
                setSelected((CitationButton) e.getSource());
                break;
        }
    }

    //EFFECTS: clear the current selections
    public void clearSelection() {
        if (selected != null) {
            selected.deselect();
        }
        selected = null;
    }

    // EFFECTS: selects the given button
    public void setSelected(CitationButton toSelect) {
        if (selected != null) {
            clearSelection();
        }
        selected = toSelect;
        selected.select();
    }

    // EFFECTS: removes the selected citation from the control panel, and clear selection as well
    public void removeSelected() {
        if (selected != null) {
            controlPanel.removeCitation(selected.getCitation());
            clearSelection();
        }
    }


    //EFFECTS: resets the current inquiry panel
    public void resetInquiry() {
        citationInquiries = mode == USE_MLA ? new MlaInquiryPanel() : new ApaInquiryPanel();
        confirm = new JButton("Confirm");
        confirm.setAlignmentX(RIGHT_ALIGNMENT);
        confirm.setAlignmentY(BOTTOM_ALIGNMENT);
        confirm.setActionCommand(COMMAND_CONFIRM);
        confirm.addActionListener(this);
        citationInquiries.add(confirm);
        splitPane.setLeftComponent(citationInquiries);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setMode(e.getItem().equals(formats[0]) ? USE_MLA : USE_APA);
    }
}
