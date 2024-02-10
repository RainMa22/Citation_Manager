package ui.cli;

import model.BooleanCriteria;
import model.Citation;
import model.IntegerCriteria;
import model.mla.MlaCitation;
import util.BooleanUtils;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


/*
 * represents the commandline Interface of the
 * */
public class CommandLineUI {
    public static final int SELECT_FORMAT = 0;
    public static final int CREATE_CITATIONS = 1;
    public static final int EXPORT = 2;
    public static final int EXIT = -1;
    public static final int USE_MLA = 0;

    private static final String WELCOME_MSG =
            "Welcome to the Citation Generator!\n"
                    + "\t The avaliable format(s) is(are):\n"
                    + "\t 0. MLA citation \n"
                    + "TIP: You can skip entering into a field by pressing Enter.\n\n"
                    + "Please choose a format(0):";
    private TreeSet<Citation> sortedCitations;
    private int mode;
    private int format;
    private CitationInquirer inquirer;

    //constructor for CommandLineUI
    // EFFECTS: creates a CommandLineUI with mode set to 0;
    CommandLineUI() {
        this.sortedCitations = new TreeSet<Citation>(new Comparator<Citation>() {
            @Override
            public int compare(Citation o1, Citation o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        this.mode = 0;
        inquirer = new CitationInquirer();
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
        } else {
            return null;
        }
    }


    // REQUIRES: mode is one of the defined constants
    // MODIFIES: this
    // EFFECTS: if mode is SELECT_FORMAT, prompt user to select format
    //                  switch mode to CREATE_CITATIONS upon assigning format
    //          if mode is CREATE_CITATIONS, prompt user to create citations
    //                  switch mode to EXPORT when user indicates done;
    //          if mode is EXPORT, print out the citation String, and set mode to EXIT
    public void update() {
        switch (mode) {
            case SELECT_FORMAT:
                format = Integer.parseInt(
                        new Prompt(WELCOME_MSG, Prompt.REPEAT_ON_FAIL, new IntegerCriteria(USE_MLA, USE_MLA)).ask());
                mode = CREATE_CITATIONS;
                break;
            case CREATE_CITATIONS:
                Citation citation = inquireAndGenerate();
                sortedCitations.add(citation);
                Boolean addMore = BooleanUtils.fromString(new Prompt("Done! Do you want to add more citations? "
                        + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL,
                        new BooleanCriteria()).ask());
                if (Boolean.FALSE.equals(addMore)) {
                    setMode(EXPORT);
                }
                break;
            case EXPORT:
                System.out.println(sortedCitations.stream().map((x) -> (x.toString()))
                        .collect(Collectors.joining("\n")));
                setMode(EXIT);
                break;
        }
    }
}
