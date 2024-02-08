package model;

public abstract class AuthorName extends CitationComponent {
    public AuthorName() {
        super();
    }

    // Requires: rawString contains more than just space
    // EFFECTS: process the given name, delimited by space, into a format according to the citation
    protected abstract void processName(String rawString);
}
