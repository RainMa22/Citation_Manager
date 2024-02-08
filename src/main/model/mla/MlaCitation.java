package model.mla;

import model.Citation;


/*
 * A citation by MLA format
 */

public class MlaCitation extends Citation {

    private static final String Template = "%1$s %2$s %3$s %4$s %5$s %6$s %7$s %8$s";
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

    //EFFECTS: generates MLA-formatted citation String based on defined variables.
    @Override
    public String toString() {

        return null;
    }
}
