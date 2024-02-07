package model;

import java.util.Date;

/*
 * An interface that represent a citable object, capable of converting filled-in
 * Field information in a citation String.
 */
public abstract class Citation {
    protected AuthorNameList authorNames;
    protected String title;
    protected String collection;
    protected Integer volume;
    protected Integer pubNum;
    protected Date pubDate;
    protected String publisher;
    protected Date accessDate;
    protected String location;

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getPubNum() {
        return pubNum;
    }

    public void setPubNum(Integer pubNum) {
        this.pubNum = pubNum;
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

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
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
