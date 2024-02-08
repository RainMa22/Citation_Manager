package model;

public abstract class AuthorName {

    @Override
    public abstract String toString();

    // Requires: rawString contains more than just space
    // EFFECTS: process the given name, delimited by space, into a format according to the citation
    protected abstract void processName(String rawString);
}
