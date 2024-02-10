package ui.cli;

import model.BooleanCriteria;
import model.DateCriteria;
import model.DummyCriteria;
import model.IntegerCriteria;

import java.util.ArrayList;
import java.util.List;

public class CitationInquirer {
    private static final Prompt[] PROMPTS = {new Prompt("Please Enter the Author Names, with proper capitalization, "
            + "separated by \',\': ", Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Please Enter the Title of the work, with proper capitalization: ",
                    Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Is the work a standalone work? "
                    + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL,
                    new BooleanCriteria()),
            new Prompt("Please Enter the Collection this work belongs to: ",
                    Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Please Enter the Volume the work belongs to (integer):",
                    Prompt.NULL_ON_FAIL, new IntegerCriteria()),
            new Prompt("Please Enter the name of the issue: ",
                    Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the publish date {yyyy[-mm(-dd)}"
                    + "(e.g 2024 or 2024-01 or 2024-01-21):",
                    Prompt.NULL_ON_FAIL, new DateCriteria()),
            new Prompt("Please enter the name of publisher with proper capitalization: ",
                    Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the URL/DOI/location of the work: ",
                    Prompt.NULL_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the access date {yyyy[-mm(-dd)}"
                    + "(e.g 2024 or 2024-01 or 2024-01-21):",
                    Prompt.NULL_ON_FAIL, new DateCriteria()),
    };

    // EFFECTS: collects the user's response to the prompts and return them in a list
    public List<String> inquire() {
        ArrayList<String> result = new ArrayList<>();
        for (Prompt prompt : PROMPTS) {
            result.add(prompt.ask());
        }
        return result;
    }
}
