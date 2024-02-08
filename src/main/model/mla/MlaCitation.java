package model.mla;

import model.Citation;
import model.SimpleCitationComponent;


/*
 * A citation by MLA format
 */

public class MlaCitation extends Citation {

    public static final int MINOR = 0;
    public static final int MAJOR = 1;
    private static final String[] TEMPLATES = {
            "%1$s %2$s %3$s %4$s %5$s %6$s %7$s %8$s",
            "%1$s %2$s %4$s %5$s %6$s %7$s %8$s"};
    private boolean minorWork;

    // Constructor for MlaCitation
    // REQUIRES: minorWork must be defined
    // EFFECTS: Constructs a MlaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, location, and access date
    public MlaCitation(String authorNames, String title, boolean minorWork, String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String location, String accessDate) {
        setAuthorNames(new MlaAuthorNameList(authorNames));
        setTitle(new MlaCitationTitle(title, minorWork));
        setMinorWork(minorWork);
        setCollection(new MlaCitationCollection(collection));
        setVolume(new SimpleCitationComponent(volume, "vol. ", ","));
        setIssueName(new SimpleCitationComponent(issueName, "", ","));
        setPubDate(new MlaCitationDate(pubDate));
        setPublisher(new SimpleCitationComponent(publisher, "", ","));
        setLocation(new SimpleCitationComponent(location, "", "."));
        setAccessDate(new MlaAccessDate(accessDate));

    }

    public boolean isMinorWork() {
        return minorWork;
    }

    public void setMinorWork(boolean minorWork) {
        this.minorWork = minorWork;
        if (minorWork) {
            setMode(MINOR);
        } else {
            setMode(MAJOR);
        }
        this.setTitle(new MlaCitationTitle(this.getTitle().getTitle(), this.minorWork));
    }

    //EFFECTS: generates MLA-formatted citation String based on defined variables.
    @Override
    protected String createBody() {
        if (mode == INACTIVE) {
            return "";
        }
        return String.format(TEMPLATES[mode], authorNames, title, collection, volume, issueName, pubDate,
                publisher, location, accessDate);
    }
}
