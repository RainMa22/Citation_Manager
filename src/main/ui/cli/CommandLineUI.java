package ui.cli;

import model.*;
import model.apa.ApaCitation;
import model.apa.ApaFullCitation;
import model.eventlogger.EventLog;
import model.mla.MlaCitation;
import model.mla.MlaFullCitation;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;
import util.BooleanUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


/*
 * represents the commandline Interface of the
 * */
public class CommandLineUI {
    public static final int LOAD_OR_NEW = 0;
    public static final int LOAD_CITATION = 1;
    public static final int SELECT_FORMAT = 2;
    public static final int CREATE_CITATIONS = 3;
    public static final int EXPORT = 4;
    public static final int SAVE_CITATION = 5;


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
        EventLog.getInstance().forEach(System.out::println);
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
    // EFFECTS: if mode is LOAD_OR_NEW, ask user whether to load or create a new citation
    //                     switch mode to LOAD_CITATION if user wants to load citation
    //                     switch mode to SELECT_FORMAT if user wants to create a new citation
    //          if mode is LOAD_CITATION, ask user for the address.
    //                     if file exists, process to ask whether they want to add to the citation;
    //                             if yes, proceed to CREATE_CITATION
    //                             else, proceed to EXPORT.
    //                     if file does not exist, print out an error message and EXIT;
    //          if mode is SELECT_FORMAT, prompt user to select format
    //                  switch mode to CREATE_CITATIONS upon assigning format
    //          if mode is CREATE_CITATIONS, prompt user to create citations
    //                  switch mode to EXPORT when user indicates done;
    //          if mode is EXPORT, print out the citation String, and asks if the user wants to save the citation,
    //                  if yes, go to SAVE_CITATION,
    //                  otherwise, goto EXIT
    //          if mode is SAVE_CITATION, prompt user for file location and save a file.
    //                  if saving is failed, prompt user again for file to save.
    //                  goto EXIT when done.
    public void update() {
        switch (mode) {
            case LOAD_OR_NEW:
                setMode(loadOrNew());
                break;
            case LOAD_CITATION:
                setMode(loadCitation());
                break;
            case SELECT_FORMAT:
                setMode(selectFormat());
                break;
            case CREATE_CITATIONS:
                setMode(createCitations());
                break;
            case EXPORT:
                setMode(export());
                break;
            case SAVE_CITATION:
                setMode(saveCitation());
                break;
        }
    }

    // helper function for update()
    // EFFECTS:  ask user whether or not to load or create a new citation
    //                    switch mode to LOAD_CITATION if user wants to load citation
    //                    switch mode to SELECT_FORMAT if user wants to create a new citation
    private int loadOrNew() {
        Prompt p = new Prompt(
                "Would you like to load a citation or create a new one? (1 for load, 2 for create):",
                Prompt.REPEAT_ON_FAIL, new IntegerCriteria(1, 2));
        int choice = Integer.parseInt(p.ask());
        return choice == 1 ? LOAD_CITATION : SELECT_FORMAT;
    }

    // helper function for update()
    // MODIFIES: this
    // EFFECTS: ask user for the address.
    //              if file exists, process to ask whether they want to modify the citation;
    //                      if yes, proceed to MODIFY_CITATION
    //                      else, proceed to EXPORT.
    //              if file does not exist, print out an error message and EXIT;
    private int loadCitation() {
        Prompt p = new Prompt("Please specify a path for your saved citation JSON file: ", Prompt.EMPTY_STRING_ON_FAIL,
                new DummyCriteria());
        String str = p.ask();
        JsonReader reader;
        try {
            reader = new JsonReader(str);
        } catch (FileNotFoundException exception) {
            System.out.println("File Not Found! Exiting!");
            return EXIT;
        }
        JSONObject json = reader.readJson();
        format = json.getString("format").equals("MLA") ? USE_MLA : USE_APA;
        sortedCitations = format == USE_MLA ? new MlaFullCitation(json) : new ApaFullCitation(json);
        p = new Prompt("Would you like to add to the citation? (yes/no)(1/0)(true/false)(t/f)(y/n):",
                Prompt.FALSE_STRING_ON_FAIL, new BooleanCriteria());
        boolean modify = Boolean.TRUE.equals(BooleanUtils.fromString(p.ask()));
        return modify ? CREATE_CITATIONS : EXPORT;
    }

    // helper function for update()
    // MODIFIES: this
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
        return CREATE_CITATIONS;
    }

    // helper function for update()
    // EFFECTS: print out the citations and save them into a JSON file.
    //          switch mode to EXIT when user indicates done;
    private int export() {
        System.out.println(sortedCitations.toString());
        Prompt p = new Prompt("Would you like to save the citation to a file?"
                + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL, new BooleanCriteria());
        if (Boolean.TRUE.equals(BooleanUtils.fromString(p.ask()))) {
            return SAVE_CITATION;
        } else {
            return EXIT;
        }
    }

    // helper function for update()
    // MODIFIES: this
    // EFFECTS: prompt user for file location and save a file.
    //                 if saving is failed, prompt user again for file to save.
    //                 goto EXIT when done.
    private int saveCitation() {
        JsonWriter writer;

        Prompt promptForOutput = new Prompt("Please enter the path of the output file: ", Prompt.EMPTY_STRING_ON_FAIL,
                new DummyCriteria());

        try {
            writer = new JsonWriter("bd.json");
        } catch (IOException e) {
            throw new RuntimeException("unexpected IOException! ", e);
        }
        boolean firstTry = true;
        do {
            if (!firstTry) {
                System.out.println("bad Path Name! Please try again");
            }
            firstTry = false;
            String output = promptForOutput.ask();
            try {
                writer = new JsonWriter(output);
            } catch (IOException e) {
                //continue
            }
        } while (!writer.writeJson(sortedCitations.asJson()));
        System.out.println("Finished saving! Exiting...");
        return EXIT;
    }

}
