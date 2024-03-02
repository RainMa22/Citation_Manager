package model;

import org.json.JSONObject;

/*
 * An interface that represent a citable object, capable of converting filled-in
 * Field information in a citation String.
 */
public abstract class Citation extends CitationComponent {
    protected AuthorNameList authorNames;
    protected CitationTitle title;
    protected CitationTitle collection;
    protected SimpleCitationComponent volume;
    protected SimpleCitationComponent issueName;
    protected CitationDate pubDate;
    protected SimpleCitationComponent publisher;
    protected CitationDate accessDate;
    protected SimpleCitationComponent location;


    //EFFECTS: put head,tail,mode, and the JSONObject representations of authorNames,title, collection, volume,
    //         issueName, pubDate, publisher, accessDate, and location in to a JSONObject and returns it.
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();

        String[] keys = ("authorNames, title, collection, volume, "
                + "issueName, pubDate, publisher, accessDate, location").split(", ");
        CitationComponent[] components = {authorNames, title, collection, volume, issueName,
                pubDate, publisher, accessDate, location};
        for (int i = 0; i < keys.length; i++) {
            out.put(keys[i], components[i].asJson());
        }
        return out;
    }


    public SimpleCitationComponent getVolume() {
        return volume;
    }

    public void setVolume(SimpleCitationComponent volume) {
        this.volume = volume;
    }

    public SimpleCitationComponent getIssueName() {
        return issueName;
    }

    public void setIssueName(SimpleCitationComponent issueName) {
        this.issueName = issueName;
    }

    public AuthorNameList getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(AuthorNameList authorNames) {
        this.authorNames = authorNames;
    }

    public CitationTitle getTitle() {
        return title;
    }

    public void setTitle(CitationTitle title) {
        this.title = title;
    }

    public CitationTitle getCollection() {
        return collection;
    }

    public void setCollection(CitationTitle collection) {
        this.collection = collection;
    }

    public CitationDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(CitationDate pubDate) {
        this.pubDate = pubDate;
    }

    public SimpleCitationComponent getPublisher() {
        return publisher;
    }

    public void setPublisher(SimpleCitationComponent publisher) {
        this.publisher = publisher;
    }

    public CitationDate getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(CitationDate accessDate) {
        this.accessDate = accessDate;
    }

    public SimpleCitationComponent getLocation() {
        return location;
    }

    public void setLocation(SimpleCitationComponent location) {
        this.location = location;
    }
}
