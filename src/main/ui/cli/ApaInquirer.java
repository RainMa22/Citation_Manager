package ui.cli;

import model.BooleanCriteria;
import model.DateCriteria;
import model.DummyCriteria;
import model.IntegerCriteria;
import util.BooleanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// An Inquirer asking the questions relevant to the creation of an APA Citation;

public class ApaInquirer implements CitationInquirable {
    private static final Prompt[] PROMPTS = new Prompt[]{
            new Prompt("Please Enter the Author Names, with proper capitalization, "
                    + "separated by \',\': ", Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Please Enter the Title of the work, with proper capitalization: ",
                    Prompt.EMPTY_STRING_ON_FAIL, new DummyCriteria()),
            new Prompt("Is the work an Academic work(i.e. a paper)? "
                    + "(yes/no)(1/0)(true/false)(t/f)(y/n): ", Prompt.FALSE_STRING_ON_FAIL,
                    new BooleanCriteria()),
            new Prompt("Would the work likely change over time to (i.e. is the work a wiki page)? "
                    + "(yes/no)(1/0)(true/false)(t/f)(y/n): ", Prompt.FALSE_STRING_ON_FAIL,
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
        ArrayList<Integer> toSkip = new ArrayList<>(0);
        for (int i = 0; i < PROMPTS.length; i++) {
            if (toSkip.contains(i)) {
                result.add(null);
                continue;
            }
            String response = PROMPTS[i].ask();
            result.add(response);

            if (i == 2) {
                //skip asking for changeOverTime, publisher and accessDate if the work is Academic work
                if (Boolean.TRUE.equals(BooleanUtils.fromString(response))) {
                    toSkip.addAll(Arrays.asList(3, 8, 10));
                } else {
                    //skip asking for collection, volume, and issueName if the work is not Academic work
                    toSkip.addAll(Arrays.asList(4, 5, 6));
                }
            } else if (i == 3 && Boolean.TRUE.equals(BooleanUtils.fromString(response))) {
                //skip accessDate if not changeOverTime
                toSkip.add(10);
            }
        }
        return result;
    }
}
