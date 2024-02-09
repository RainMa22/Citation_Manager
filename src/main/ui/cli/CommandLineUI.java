package ui.cli;

import model.Citation;
import util.BooleanCriteria;
import util.BooleanUtils;
import util.DummyCriteria;
import util.IntegerCriteria;

import java.util.Comparator;
import java.util.TreeSet;


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
                    + "\t 1. MLA citation \n"
                    + "TIP: You can skip entering into a field by pressing Enter.";
    private TreeSet<Citation> sortedCitations;
    private int mode;
    private int format;

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

    // REQUIRES: mode is one of the defined constants
    // MODIFIES: this
    // EFFECTS: if mode is SELECT_FORMAT, prompt user to select format
    //                  switch mode to CREATE_CITATIONS upon assigning format
    //          if mode is CREATE_CITATIONS, prompt user to create citations
    //                  switch mode to EXPORT when user indicates done;
    //          if mdoe is EXPORT, print out the citation String, and set mode to EXIT
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void update() {
        switch (mode) {
            case SELECT_FORMAT:
                System.out.println(WELCOME_MSG);
                format = Integer.parseInt(
                        new Prompt("Please choose a format[0]:", Prompt.REPEAT_ON_FAIL,
                                new IntegerCriteria(USE_MLA, USE_MLA)).ask());
                mode = CREATE_CITATIONS;
                break;
            case CREATE_CITATIONS:
                if (format == USE_MLA) {
                    String authorNames = new Prompt("Please Enter the Author Names, with proper capitalization, "
                            + "separated by \'.\': ", Prompt.NULL_ON_FAIL, new DummyCriteria()).ask();
                    String title = new Prompt("Please Enter the Title of the work, with proper capitalization: ",
                            Prompt.NULL_ON_FAIL, new DummyCriteria()).ask();
                    Boolean minor = BooleanUtils.fromString(new Prompt("Is the work a standalone work? "
                            + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL,
                            new BooleanCriteria()).ask());
                    minor = Boolean.TRUE.equals(minor); // avoids nullPointerException
                    String collection = null;
                    Integer volume = null;
                    String issueName = null;
                    if (minor) {
                        collection = new Prompt("Please Enter the Collection this work belongs to: ",
                                Prompt.NULL_ON_FAIL, new DummyCriteria()).ask();
                        volume = Integer.parseInt(new Prompt("Please Enter the Volume the work belongs to (integer):",
                                Prompt.NULL_ON_FAIL, new IntegerCriteria()).ask());
                        issueName = new Prompt("Please Enter the name of the issue: ",
                                Prompt.NULL_ON_FAIL, new DummyCriteria()).ask();
                    }
                    //pubDate, publisher, location, AccessDate, ways to switch mode to EXPORT;

                }

        }
    }
}
