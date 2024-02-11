package model.apa;

import model.Citation;
import model.SimpleCitationComponent;
import util.BooleanUtils;

import java.util.List;


/*
 * A citation by APA format
 */

public class ApaCitation extends Citation {

    public static final int ACADEMIC_WORK = 0;
    public static final int WEBPAGE = 1;
    public static final int WEBPAGE_SUBJECT_TO_CHANGE = 2;
    private static final String[] TEMPLATES = {
            "%1$s%6$s%2$s%3$s%4$s%5$s%8$s",
            "%1$s%6$s%2$s%7$s%8$s",
            "%1$s%6$s%2$s%7$s%8$s%9$s"
    };

    //[authorNames]. ([pubDate]). [title], [{[collection], [volume][IssueName]} if acdademicWork else [publisher]].
    //              [{retrieved [accessDate] from ]} if subjectToChange&!academicWork][Location]

    // String authorNames, String title, String collection, Integer volume,
    //                       String issueName, String pubDate, String publisher, String location, String accessDate

    // Constructor for ApaCitation
    // EFFECTS: Alternate way to construct a ApaCitation using a list of Strings
    //          constructs a ApaCitation using the first 11 items of the list
    //          throws an IllegalArgumentException when the strings passed has < 11 strings
    public ApaCitation(List<String> param) throws IllegalArgumentException {
        if (param.size() < 11) {
            throw new IllegalArgumentException();
        }
        setAuthorNames(new ApaAuthorNameList(param.get(0)));
        boolean acdemicWork = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(2)));
        boolean subjectToChange = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(10)));
        setTitle(new ApaCitationTitle(param.get(1), acdemicWork));
        setAcademicWork(acdemicWork, subjectToChange);
        setCollection(new ApaCitationCollection(param.get(3)));
        try {
            setVolume(new SimpleCitationComponent(Integer.valueOf(param.get(4)), "vol.", ", "));
        } catch (NumberFormatException nfe) {
            setVolume(new SimpleCitationComponent(null, "vol.", ", "));
        }
        setIssueName(new SimpleCitationComponent(param.get(5), "", ", "));
        setPubDate(new ApaCitationDate(param.get(6), acdemicWork));
        setPublisher(new SimpleCitationComponent(param.get(7), "", ", "));
        setLocation(new SimpleCitationComponent(param.get(8), "", ". "));
        setAccessDate(new ApaAccessDate(param.get(9)));
    }

    // Constructor for ApaCitation
    // EFFECTS: Constructs a ApaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, location, and access date
    public ApaCitation(String authorNames, String title, boolean acdemicWork, String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String location, String accessDate,
                       boolean subjectToChange) {
        setAuthorNames(new ApaAuthorNameList(authorNames));
        setTitle(new ApaCitationTitle(title, acdemicWork));
        setAcademicWork(acdemicWork, subjectToChange);
        setCollection(new ApaCitationCollection(collection));
        setVolume(new SimpleCitationComponent(volume, "", ""));
        setIssueName(new SimpleCitationComponent(issueName, "(", "). "));
        setPubDate(new ApaCitationDate(pubDate, acdemicWork));
        setPublisher(new SimpleCitationComponent(publisher, "", ", "));
        setLocation(new SimpleCitationComponent(location, "", ""));
        setAccessDate(new ApaAccessDate(accessDate));
    }

    public boolean isAcademicWork() {
        return mode == ACADEMIC_WORK;
    }

    public void setAcademicWork(boolean academicWork, boolean subjectToChange) {
        if (academicWork) {
            setMode(ACADEMIC_WORK);
        } else {
            setMode(subjectToChange ? WEBPAGE_SUBJECT_TO_CHANGE : WEBPAGE);
        }
        this.setTitle(new ApaCitationTitle(this.getTitle().getTitle(), isAcademicWork()));
    }

    //EFFECTS: generates APA-formatted citation String based on defined variables.
    @Override
    protected String createBody() {
        return String.format(TEMPLATES[mode], authorNames, title, collection, volume, issueName, pubDate,
                publisher, location, accessDate).trim();
    }
}
