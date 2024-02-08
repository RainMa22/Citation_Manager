package ui.cli;

import model.Citation;
import util.IntegerCriteria;

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
    private TreeSet<Citation> sortedCitations;
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

    // REQUIRES: mode is one of the defined constants
    // MODIFIES: this
    // EFFECTS: if mode is SELECT_FORMAT, prompt user to select format
    //                  switch mode to CREATE_CITATIONS upon assigning format
    //          if mode is CREATE_CITATIONS, prompt user to create citations
    //                  switch mode to EXPORT if user inputs "!done";
    //          if mdoe is EXPORT, print out the citation String, and set mode to EXIT
    public void update() {
        switch (mode) {
            case SELECT_FORMAT:
                format = Integer.parseInt(
                        new Prompt("Please choose a format[1]", Prompt.REPEAT_ON_FAIL,
                                new IntegerCriteria(USE_MLA, USE_MLA)).ask());
                mode = CREATE_CITATIONS;
                break;
        }
    }
}
