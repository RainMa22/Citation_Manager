package model.apa;

import model.Citation;
import model.SimpleCitationComponent;
import util.BooleanUtils;

import java.util.List;


/*
 * A citation by MLA format
 */

public class ApaCitation extends Citation {

    public static final int MINOR = 0;
    public static final int MAJOR = 1;
    private static final String TEMPLATE = "%1$s%2$s%3$s%4$s%5$s%6$s%7$s%8$s%9$s";
    private boolean minorWork;

    // Constructor for ApaCitation
    // EFFECTS: Alternate way to construct a ApaCitation using a list of Strings
    //          constructs a ApaCitation using the first 10 items of the list
    //          throws an IllegalArgumentException when the strings passed has < 10 strings
    public ApaCitation(List<String> param) throws IllegalArgumentException {
        if (param.size() < 10) {
            throw new IllegalArgumentException();
        }
        setAuthorNames(new ApaAuthorNameList(param.get(0)));
        boolean minorWork = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(2)));
        setTitle(new ApaCitationTitle(param.get(1), minorWork));
        setMinorWork(minorWork);
        setCollection(new ApaCitationCollection(param.get(3)));
        try {
            setVolume(new SimpleCitationComponent(Integer.valueOf(param.get(4)), "vol.", ", "));
        } catch (NumberFormatException nfe) {
            setVolume(new SimpleCitationComponent(null, "vol.", ", "));
        }
        setIssueName(new SimpleCitationComponent(param.get(5), "", ", "));
        setPubDate(new ApaCitationDate(param.get(6)));
        setPublisher(new SimpleCitationComponent(param.get(7), "", ", "));
        setLocation(new SimpleCitationComponent(param.get(8), "", ". "));
        setAccessDate(new ApaAccessDate(param.get(9)));
    }

    // Constructor for ApaCitation
    // EFFECTS: Constructs a ApaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, location, and access date
    public ApaCitation(String authorNames, String title, boolean minorWork, String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String location, String accessDate) {
        setAuthorNames(new ApaAuthorNameList(authorNames));
        setTitle(new ApaCitationTitle(title, minorWork));
        setMinorWork(minorWork);
        setCollection(new ApaCitationCollection(collection));
        setVolume(new SimpleCitationComponent(volume, "vol.", ", "));
        setIssueName(new SimpleCitationComponent(issueName, "", ", "));
        setPubDate(new ApaCitationDate(pubDate));
        setPublisher(new SimpleCitationComponent(publisher, "", ", "));
        setLocation(new SimpleCitationComponent(location, "", ". "));
        setAccessDate(new ApaAccessDate(accessDate));
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
        this.setTitle(new ApaCitationTitle(this.getTitle().getTitle(), this.minorWork));
    }

    //EFFECTS: generates MLA-formatted citation String based on defined variables.
    @Override
    protected String createBody() {
        return String.format(TEMPLATE, authorNames, title, collection, volume, issueName, pubDate,
                publisher, location, accessDate).trim();
    }
}
