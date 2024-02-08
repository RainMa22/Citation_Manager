package model;

/*
 * The title of a Citation in a citation, usually a name of the book or the article title.*/
public abstract class CitationTitle {
    protected String title;

    // constuctor for CitationTitle
    // EFFECTS: creates CitationTitle with the given title
    public CitationTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public abstract String toString();

}
