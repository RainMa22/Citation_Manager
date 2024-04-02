package ui.cli;

import model.BooleanCriteria;
import model.DateCriteria;
import model.DummyCriteria;
import model.IntegerCriteria;
import util.BooleanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// An Inquirer asking the questions relevant to the creation of an MLA Citation;

public class MlaInquirer implements CitationInquirable {
    private static final Prompt[] PROMPTS = new Prompt[]{
            new Prompt("Please Enter the Author Names, with proper capitalization, "
                    + "separated by \',\': ", Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please Enter the Title of the work, with proper capitalization: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Is the work a standalone work? "
                    + "(yes/no)(1/0)(true/false)(t/f)(y/n):", Prompt.FALSE_STRING_ON_FAIL,
                    new BooleanCriteria()),
            new Prompt("Please Enter the Collection this work belongs to: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please Enter the Volume the work belongs to (integer): ",
                    Prompt.EMPTY_STRING_ON_FAIL, new IntegerCriteria()),
            new Prompt("Please Enter the name of the issue: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the publish date {yyyy[-mm(-dd)}"
                    + "(e.g 2024 or 2024-01 or 2024-01-21): ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DateCriteria()),
            new Prompt("Please enter the name of publisher with proper capitalization: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the URL/DOI/location of the work: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please enter the access date {yyyy[-mm(-dd)}"
                    + "(e.g 2024 or 2024-01 or 2024-01-21): ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DateCriteria())};

    @Override
    public List<String> inquire() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> toSkip = new ArrayList<>();
        for (int i = 0; i < PROMPTS.length; i++) {
            if (toSkip.contains(i)) {
                result.add(null);
                continue;
            }
            Prompt prompt = PROMPTS[i];
            String response = prompt.ask();
            result.add(response);
            //skip asking for collection,volume, and issueName if the work is standalone work
            if (i == 2 && Boolean.TRUE.equals(BooleanUtils.fromString(response))) {
                result.addAll(Arrays.asList("", "", ""));
                i += 3;
            } else if (i == 6 && new DateCriteria().isSatisfiedBy(response)) {
                //skip accessDate if pubDate is valid
                toSkip.add(9);
            }
        }
        return result;
    }
}
