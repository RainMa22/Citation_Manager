package model.mla;

import model.AuthorNameList;
import model.Citation;
import model.CitationDate;

/*
 * A citation by MLA format
 */

public class MlaCitation extends Citation {

    private boolean minorWork;

    // Constructor for MlaCitation
    // EFFECTS: Constructs a MlaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, and location
    public MlaCitation(String authorNames, String title, boolean minorWork, String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String accessDate,
                       String location) {
        setAuthorNames(new MlaAuthorNameList(authorNames));
        setTitle(title);
        this.minorWork = minorWork;
        setCollection(collection);
        setVolume(volume);
        setIssueName(issueName);
        setPubDate(new MlaCitationDate(pubDate));
        setPublisher(publisher);
        setAccessDate(new MlaCitationDate(accessDate));
        setLocation(location);
    }

    public boolean isMinorWork() {
        return minorWork;
    }

    public void setMinorWork(boolean minorWork) {
        this.minorWork = minorWork;
    }

    @Override
    public String cite() {
        return null;
    }
}
