package ui.cli;

import model.BooleanCriteria;
import model.Citation;
import model.FullCitation;
import model.IntegerCriteria;
import model.apa.ApaCitation;
import model.apa.ApaFullCitation;
import model.mla.MlaCitation;
import model.mla.MlaFullCitation;
import util.BooleanUtils;

import java.util.List;


/*
 * represents the commandline Interface of the
 * */
public class CommandLineUI {
    public static final int SELECT_FORMAT = 0;
    public static final int CREATE_CITATIONS = 1;
    public static final int EXPORT = 2;
    //TODO
    // public static final int LOAD_CITATION;
    // public static final int MODIFY_CITATION;
    // public static final int TO_FILE;



    public static final int EXIT = -1;
    public static final int USE_MLA = 0;
    public static final int USE_APA = 1;

    private static final String WELCOME_MSG =
            "Welcome to the Citation Generator!\n"
                    + "\t The avaliable format(s) is(are):\n"
                    + "\t 1. MLA citation \n"
                    + "\t 2. APA citation \n"
                    + "TIP: You can skip entering into a field by pressing Enter.\n\n"
                    + "Please choose a format(1 or 2): ";
    private CitationInquirable inquirer;
    private FullCitation sortedCitations;
    private int mode;
    private int format;

    //constructor for CommandLineUI
    // EFFECTS: creates a CommandLineUI with mode set to 0;
    CommandLineUI() {
        this.mode = 0;
    }

    public static void main(String[] args) {
        //initialization
        CommandLineUI ui = new CommandLineUI();
        //mainloop
        while (ui.getMode() != EXIT) {
            ui.update();
        }
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    //EFFECTS: asks and generates a citation
    public Citation inquireAndGenerate() {
        List<String> result = inquirer.inquire();
        if (format == USE_MLA) {
            return new MlaCitation(result);
        } else if (format == USE_APA) {
            return new ApaCitation(result);
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: if mode is SELECT_FORMAT, prompt user to select format
    //                  switch mode to CREATE_CITATIONS upon assigning format
    //          if mode is CREATE_CITATIONS, prompt user to create citations
    //                  switch mode to EXPORT when user indicates done;
    //          if mode is EXPORT, print out the citation String, and set mode to EXIT
    public void update() {
        switch (mode) {
            case SELECT_FORMAT:
                setMode(selectFormat());
                break;
            case CREATE_CITATIONS:
                setMode(createCitations());
                break;
            case EXPORT:
                setMode(export());
                break;
        }
    }

    // helper function for update()
    // EFFECTS: prompt user to select format
    //          return CREATE_CITATIONS upon assigning format
    private int selectFormat() {
        format = Integer.parseInt(new Prompt(WELCOME_MSG, Prompt.REPEAT_ON_FAIL,
                new IntegerCriteria(USE_MLA + 1, USE_APA + 1)).ask()) - 1;
        inquirer = format == USE_MLA ? new MlaInquirer() : new ApaInquirer();
        sortedCitations = format == USE_MLA ? new MlaFullCitation() : new ApaFullCitation();
        return CREATE_CITATIONS;
    }

    // helper function for update()
    // EFFECTS: prompt user to create a citation of defined FORMAT
    //          switch mode to EXPORT when user indicates done;
    private int createCitations() {
        Citation citation = inquireAndGenerate();
        sortedCitations.add(citation);
        Boolean addMore = BooleanUtils.fromString(new Prompt("Done! Do you want to add more citations? "
                + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL,
                new BooleanCriteria()).ask());
        if (Boolean.FALSE.equals(addMore)) {
            return EXPORT;
        }
        return SELECT_FORMAT;
    }

    private int export() {
        System.out.println(sortedCitations.toString());
        return EXIT;
    }

}
