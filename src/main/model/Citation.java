package model;

/*
 * An interface that represent a citable object, capable of converting filled-in
 * Field information in a citation String.
 */
public abstract class Citation {
    protected AuthorNameList authorNames;
    protected String title;
    protected String collection;
    protected Integer volume;
    protected String issueName;
    protected CitationDate pubDate;
    protected String publisher;
    protected CitationDate accessDate;
    protected String location;


    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public AuthorNameList getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(AuthorNameList authorNames) {
        this.authorNames = authorNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public CitationDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(CitationDate pubDate) {
        this.pubDate = pubDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public CitationDate getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(CitationDate accessDate) {
        this.accessDate = accessDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // REQUIRE: Citable.isValid()
    // EFFECTS: Condense all the Fields into a valid citation string and outputs it.
    public abstract String cite();
}
