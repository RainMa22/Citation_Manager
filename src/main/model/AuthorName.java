package model;

public abstract class AuthorName {
    //Constructor for AuthorName
    protected AuthorName(String rawString) throws InvalidFormatException {
        processName(rawString);
    }

    // EFFECTS: converts name to the citation String according to the citation format
    @Override
    public abstract String toString();

    // EFFECTS: process the given name, delimited by space, into a format according to the citation
    protected abstract void processName(String rawString) throws InvalidFormatException;
}
