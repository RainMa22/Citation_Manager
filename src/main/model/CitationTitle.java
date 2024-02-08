package model;

/*
 * The title of a Citation in a citation, usually a name of the book or the article title.*/
public abstract class CitationTitle extends CitationComponent {
    protected String title;

    // constuctor for CitationTitle
    // EFFECTS: creates CitationTitle with the given title
    public CitationTitle(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
