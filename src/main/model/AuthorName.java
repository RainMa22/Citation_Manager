package model;

public abstract class AuthorName {

    // EFFECTS: converts name to the citation String according to the citation format
    public String cite() {
        return this.toString();
    }

    @Override
    public abstract String toString();

    // EFFECTS: process the given name, delimited by space, into a format according to the citation
    protected abstract void processName(String rawString) throws InvalidFormatException;
}
