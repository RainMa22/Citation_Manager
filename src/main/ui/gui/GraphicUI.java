package ui.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * Class representing the GUI Frame of the Citation Generator
 * */
public class GraphicUI extends JFrame implements ActionListener {
    private static final String TITLE = "Citation Generator";
    private static final String COMMAND_CONFIRM = "submit";
    private final JPanel citationInquiries;
    private final JButton confirm;

    //Constructor
    // EFFECTS: constructs the GUI for citation generation
    public GraphicUI() {
        super(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        JSplitPane splitPane = new JSplitPane();

        JLabel dummy = new JLabel("dsad");
        dummy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        confirm = new JButton("Confirm");
        confirm.setAlignmentX(RIGHT_ALIGNMENT);
        confirm.setAlignmentY(BOTTOM_ALIGNMENT);

        confirm.setActionCommand(COMMAND_CONFIRM);
        confirm.addActionListener(this);
        citationInquiries = new JPanel();
        citationInquiries.add(dummy);
        citationInquiries.add(confirm);
        splitPane.setLeftComponent(citationInquiries);
        CitationListPanel citationList = new CitationListPanel();
        splitPane.setRightComponent(citationList);
        add(splitPane);
        pack();
        splitPane.setDividerLocation(.8);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    public static void main(String[] args) {
        new GraphicUI();
    }

    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(COMMAND_CONFIRM)) {
            //TODO
        }
    }
}
