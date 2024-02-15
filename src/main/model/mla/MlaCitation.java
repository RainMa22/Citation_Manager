package model.mla;

import model.Citation;
import util.BooleanUtils;

import java.util.List;


/*
 * A citation by MLA format
 */

public class MlaCitation extends Citation {

    public static final int MINOR = 0;
    public static final int MAJOR = 1;
    private static final String TEMPLATE = "%1$s%2$s%3$s%4$s%5$s%6$s%7$s%8$s%9$s";
    private boolean minorWork;

    // Constructor for MlaCitation
    // EFFECTS: Alternate way to construct a MlaCitation using a list of Strings
    //          constructs a MlaCitation using the first 10 items of the list
    //          throws an IllegalArgumentException when the strings passed has < 10 strings
    public MlaCitation(List<String> param) throws IllegalArgumentException {
        if (param.size() < 10) {
            throw new IllegalArgumentException("Needs at least 10 Strings(including null) to create a MlaCitation!");
        }
        setAuthorNames(new MlaAuthorNameList(param.get(0)));
        boolean minorWork = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(2)));
        setTitle(new MlaCitationTitle(param.get(1), minorWork));
        setMinorWork(minorWork);
        setCollection(new MlaCitationCollection(param.get(3)));
        try {
            setVolume(new MlaVolume(Integer.valueOf(param.get(4))));
        } catch (NumberFormatException nfe) {
            setVolume(new MlaVolume(null));
        }
        setIssueName(new MlaIssueName(param.get(5)));

        MlaCitationDate pubDate = new MlaCitationDate(param.get(6));
        MlaAccessDate accessDate = new MlaAccessDate(param.get(9));
        if (pubDate.getDate() != null) {
            accessDate.setMode(INACTIVE);
        }

        setPubDate(pubDate);
        setPublisher(new MlaPublisher(param.get(7)));
        setLocation(new MlaLocation(param.get(8)));
        setAccessDate(accessDate);
    }

    // Constructor for MlaCitation
    // EFFECTS: Constructs a MlaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, location, and access date
    public MlaCitation(String authorNames, String title, boolean minorWork, String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String location, String accessDate) {
        setAuthorNames(new MlaAuthorNameList(authorNames));
        setTitle(new MlaCitationTitle(title, minorWork));
        setMinorWork(minorWork);
        setCollection(new MlaCitationCollection(collection));
        setVolume(new MlaVolume(volume));
        setIssueName(new MlaIssueName(issueName));
        MlaCitationDate pubDate1 = new MlaCitationDate(pubDate);
        MlaAccessDate accessDate1 = new MlaAccessDate(accessDate);
        if (pubDate1.getDate() != null) {
            accessDate1.setMode(INACTIVE);
        }
        setPubDate(pubDate1);
        setPublisher(new MlaPublisher(publisher));
        setLocation(new MlaLocation(location));
        setAccessDate(accessDate1);
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
        return String.format(TEMPLATE, authorNames, title, collection, volume, issueName, pubDate,
                publisher, location, accessDate).trim();
    }
}
