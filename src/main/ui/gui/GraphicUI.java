package ui.gui;

import org.json.JSONObject;
import persistence.JsonReader;
import ui.gui.apa.ApaFullGuiCitation;
import ui.gui.apa.ApaGuiCitation;
import ui.gui.apa.ApaInquiryPanel;
import ui.gui.mla.MlaFullGuiCitation;
import ui.gui.mla.MlaGuiCitation;
import ui.gui.mla.MlaInquiryPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
 * Class representing the GUI Frame of the Citation Generator
 * */
public class GraphicUI extends JFrame implements ActionListener, ItemListener {
    private static final String[] formats = {"MLA", "APA"};
    private static final String TITLE = "Citation Generator";
    private static final String COMMAND_CONFIRM = "submit";
    private static final String HTML_SUFFIX = "html";
    private static final String JSON_SUFFIX = "json";
    private static final int USE_MLA = 0;
    private static final int USE_APA = 1;

    private JButton confirm;

    private CitationInquiryPanel citationInquiries;
    private JSplitPane splitPane;
    private CitationControlPanel controlPanel;
    private int mode;
    private CitationButton selected;
    private JFileChooser fileChooser;

    //Constructor
    // EFFECTS: constructs the GUI for citation generation
    public GraphicUI() {
        super(TITLE);
        CitationMenuBar menuBar = new CitationMenuBar();
        selected = null;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        splitPane = new JSplitPane();
        controlPanel = new CitationControlPanel();
        splitPane.setRightComponent(controlPanel);
        fileChooser = new JFileChooser(Path.of("").toAbsolutePath().toFile());

        setJMenuBar(menuBar);
        add(splitPane);
        pack();
        splitPane.setDividerLocation(.8);
        setMode(USE_MLA);

        controlPanel.addActionListener(this);
        menuBar.addActionListener(this);

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

        FullGuiCitation fullCitation = mode == USE_MLA ? new MlaFullGuiCitation() : new ApaFullGuiCitation();
        controlPanel.setFullGuiCitation(fullCitation);
        splitPane.setRightComponent(controlPanel);
    }

    //EFFECTS: set mode to the changed state
    @Override
    public void itemStateChanged(ItemEvent e) {
        setMode(e.getItem().equals(formats[0]) ? USE_MLA : USE_APA);
    }


    // EFFECT: This is the method that is called when the JButton btn is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case COMMAND_CONFIRM:
                confirmCommand();
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
            case CitationMenuBar.SAVE_CITATION:
                saveCitation();
                break;
            case CitationMenuBar.EXPORT_CITATION:
                exportCitation();
                break;
            case CitationMenuBar.LOAD_CITATION:
                loadCitation(fileChooser, JSON_SUFFIX);
        }
    }

    // EFFECTS: save a citation to the user-inputted file
    public void saveCitation() {
        writeToFile(fileChooser, "Save", controlPanel.getCitation(), HTML_SUFFIX);
    }

    // EFFECTS: exports a citation to a user-inputted JSON file
    public void exportCitation() {
        writeToFile(fileChooser, "Export", controlPanel.getCitation().asJson(), JSON_SUFFIX);
    }

    // EFFECTS: loads a citation from a user-inputted JSONfile
    public void loadCitation(JFileChooser fileChooser, String suffix) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(suffix.toUpperCase() + " File", suffix);
        while (true) {
            fileChooser.addChoosableFileFilter(filter);
            //fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int status = fileChooser.showOpenDialog(this);
            if (status == JFileChooser.APPROVE_OPTION) {
                try {
                    JsonReader reader = new JsonReader(fileChooser.getSelectedFile().getAbsolutePath());
                    JSONObject json = reader.readJson();
                    if (json == null) {
                        throw new IOException();
                    }
                    setMode(json.getString("format").equals("MLA") ? USE_MLA : USE_APA);
                    controlPanel.setFullGuiCitation(
                            mode == USE_MLA ? new MlaFullGuiCitation(json) : new ApaFullGuiCitation(json));
                    break;
                } catch (FileNotFoundException fnfe) {
                    displayWarning("File Not Found! Please try again!");
                } catch (IOException e) {
                    displayWarning("Exception Occurred when reading!! Please try again!");
                }
            }
        }
    }

    // EFFECTS: Display a warning message with the given message;
    public void displayWarning(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                "WARNING", JOptionPane.WARNING_MESSAGE);

    }

    // EFFECTS: writes the given Object to the file chosen by user with the given approveOption, and file Filter
    public void writeToFile(JFileChooser fileChooser, String approveOption, Object toWrite, String suffix) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(suffix.toUpperCase() + " File", suffix);
        while (true) {
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int status = fileChooser.showDialog(this, approveOption);
            if (status == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                if (!filter.accept(f)) {
                    f = new File(String.join(".", f.getAbsolutePath(), suffix));
                }
                try {
                    Path output = Path.of(f.getAbsolutePath());
                    Files.writeString(output, toWrite.toString());
                    break;
                } catch (IOException e) {
                    displayWarning("Exception when writing file! Please try again!");
                }
            }
        }
    }

    // EFFECTS: create a new Citation from user input and put it to the control panel, resets the inquiry.
    public void confirmCommand() {
        List<String> param = citationInquiries.getStringListVal();
        param = param.subList(1, param.size());
        removeSelected();
        controlPanel.addCitation(mode == USE_MLA ? new MlaGuiCitation(param) : new ApaGuiCitation(param));
        resetInquiry();
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
        citationInquiries.fromStringListVal(toSelect.getCitation().getUserInput());
    }

    // EFFECTS: removes the selected citation from the control panel, and clear selection as well
    public void removeSelected() {
        if (selected != null) {
            controlPanel.removeCitation(selected.getCitation());
            resetInquiry();
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
        citationInquiries.getFormatSelector().addItemListener(this);
        citationInquiries.add(confirm);
        splitPane.setLeftComponent(citationInquiries);
    }


}
