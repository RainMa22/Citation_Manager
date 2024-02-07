package model.mla;

import model.AuthorNameList;
import model.Citation;
import model.CitationDate;

/*
 * A citation by MLA format
 */

public class MlaCitation extends Citation {

    // Constructor for MlaCitation
    // EFFECTS: Constructs a MlaCitation with given authorName, title, collection name, volume, pubNum, pubDate,
    //          publisher, and location
    public MlaCitation(AuthorNameList authorNames, String title, String collection, Integer volume,
                       Integer pubNum, CitationDate pubDate, String publisher, CitationDate accessDate,
                       String location) {
        setAuthorNames(authorNames);
        setTitle(title);
        setCollection(collection);
        setVolume(volume);
        setPubNum(pubNum);
        setPubDate(pubDate);
        setPublisher(publisher);
        setAccessDate(accessDate);
        setLocation(location);
    }

    @Override
    public String cite() {
        return null;
    }
}
