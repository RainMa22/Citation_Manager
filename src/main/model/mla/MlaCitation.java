package model.mla;

import model.Citation;

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
        setTitle(new MlaCitationTitle(title, minorWork));
        this.minorWork = minorWork;
        setCollection(new MlaCitationCollection(collection));
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

    //EFFECTS: generates the following string
    //          [authorName]. [title]. [collection], vol.[50], [issueName], [pubdate], [location]. [accessDate].
    @Override
    public String cite() {
        return null;
    }
}
