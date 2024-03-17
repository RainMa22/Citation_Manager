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
    private CitationListPanel citationList;
    private int mode;

    //Constructor
    // EFFECTS: constructs the GUI for citation generation
    public GraphicUI() {
        super(TITLE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        splitPane = new JSplitPane();
        citationList = new CitationListPanel();
        splitPane.setRightComponent(citationList);
        add(splitPane);
        pack();
        splitPane.setDividerLocation(.8);
        setMode(USE_MLA);
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
        citationInquiries = mode == USE_MLA ? new MlaInquiryPanel() : new ApaInquiryPanel();
        FullCitation fullCitation = mode == USE_MLA ? new MlaFullCitation() : new ApaFullCitation();

        confirm = new JButton("Confirm");
        confirm.setAlignmentX(RIGHT_ALIGNMENT);
        confirm.setAlignmentY(BOTTOM_ALIGNMENT);
        confirm.setActionCommand(COMMAND_CONFIRM);
        confirm.addActionListener(this);

        citationInquiries.add(confirm);
        setCitationInquiries(citationInquiries);
        citationList.setFullCitation(fullCitation);
        splitPane.setRightComponent(citationList);
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
                citationList.addCitation(mode == USE_MLA ? new MlaCitation(param) : new ApaCitation(param));
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setMode(e.getItem().equals(formats[0]) ? USE_MLA : USE_APA);
    }
}
