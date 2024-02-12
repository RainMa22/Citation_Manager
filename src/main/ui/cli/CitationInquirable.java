package ui.cli;

import java.util.List;

public interface CitationInquirable {

    // EFFECTS: collects the user's response to the prompts and return them in a list
    public abstract List<String> inquire();
}
