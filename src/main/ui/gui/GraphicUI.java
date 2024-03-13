package ui.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Class representing the GUI Frame of the Citation Generator
 * */
public class GraphicUI extends JFrame implements ActionListener {
    private static final String TITLE = "Citation Generator";
    private static final String COMMAND_SUBMIT = "submit";
    private final JPanel citationInquiries;
    private final JButton submit;

    //Constructor
    // EFFECTS: constructs the GUI for citation generation
    public GraphicUI() {
        super(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        //setPreferredSize(new Dimension(800, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        citationInquiries = new GridPanel(1, 1);
        citationInquiries.setSize(800, 500);
        JLabel dummy = new JLabel("dsad");
        dummy.setSize(800, 500);
        citationInquiries.add(dummy);
        submit = new JButton("Submit");
        submit.setAlignmentY(BOTTOM_ALIGNMENT);
        submit.setAlignmentX(Component.RIGHT_ALIGNMENT);
        submit.setActionCommand(COMMAND_SUBMIT);
        submit.addActionListener(this); // Sets "this" object as an action listener for btn
        add(citationInquiries);
        add(submit);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new GraphicUI();
    }

    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(COMMAND_SUBMIT)) {
            //TODO
        }
    }
}
