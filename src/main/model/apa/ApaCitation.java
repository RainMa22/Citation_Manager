package model.apa;

import model.Citation;
import org.json.JSONObject;
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
            "%1$s%6$s%2$s%7$s%9$s%8$s"
    };

    //[authorNames]. ([pubDate]). [title], [{[collection], [volume][IssueName]} if acdademicWork else [publisher]].
    //              [{retrieved [accessDate] from]} if subjectToChange&!academicWork][Location]

    // String authorNames, String title, String collection, Integer volume,
    //                       String issueName, String pubDate, String publisher, String location, String accessDate

    // Constructor for ApaCitation
    // EFFECTS: Alternate way to construct a ApaCitation using a list of Strings
    //          constructs a ApaCitation using the first 11 items of the list
    //          throws an IllegalArgumentException when the strings passed has < 11 strings
    public ApaCitation(List<String> param) throws IllegalArgumentException {
        if (param.size() < 11) {
            throw new IllegalArgumentException("Needs at least 11 Strings(including null) to create a ApaCitation!");
        }
        setAuthorNames(new ApaAuthorNameList(param.get(0)));
        boolean acdemicWork = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(2)));
        boolean subjectToChange = Boolean.TRUE.equals(BooleanUtils.fromString(param.get(3)));
        setTitle(new ApaCitationTitle(param.get(1), acdemicWork));
        setAcademicWork(acdemicWork, subjectToChange);
        setCollection(new ApaCitationCollection(param.get(4)));
        Integer volume;
        try {
            volume = Integer.valueOf(param.get(5));
        } catch (NumberFormatException nfe) {
            volume = null;
        }
        setVolume(new ApaVolume(volume));
        setIssueName(new ApaIssueName(param.get(6)));
        setPubDate(new ApaCitationDate(param.get(7), acdemicWork));
        setPublisher(new ApaPublisher(param.get(8)));
        setLocation(new ApaLocation(param.get(9)));
        setAccessDate(new ApaAccessDate(param.get(10)));
    }
    // String authorNames, String title, String collection, Integer volume,
    //                       String issueName, String pubDate, String publisher, String location, String accessDate

    // Constructor for ApaCitation
    // EFFECTS: Alternate way to construct a ApaCitation using a JSONObject
    //          set head,tail, mode, authorNames, title, collection, volume, issueName, pubDate, publisher, location,
    //          and accessDate according to the given JSONObject
    public ApaCitation(JSONObject json) {
        super(json);
        setAuthorNames(new ApaAuthorNameList(json.getJSONObject("authorNames")));
        setTitle(new ApaCitationTitle(json.getJSONObject("title")));
        setCollection(new ApaCitationCollection(json.getJSONObject("collection")));
        setVolume(new ApaVolume(json.getJSONObject("volume")));
        setIssueName(new ApaIssueName(json.getJSONObject("issueName")));
        setPubDate(new ApaCitationDate(json.getJSONObject("pubDate")));
        setPublisher(new ApaPublisher(json.getJSONObject("publisher")));
        setLocation(new ApaLocation(json.getJSONObject("location")));
        setAccessDate(new ApaAccessDate(json.getJSONObject("accessDate")));
    }

    // Constructor for ApaCitation
    // EFFECTS: Constructs a ApaCitation with given authorName, title, collection name, volume, issueName, pubDate,
    //          publisher, location, and access date
    public ApaCitation(String authorNames, String title, boolean acdemicWork, boolean subjectToChange,
                       String collection, Integer volume,
                       String issueName, String pubDate, String publisher, String location, String accessDate) {
        setAuthorNames(new ApaAuthorNameList(authorNames));
        setTitle(new ApaCitationTitle(title, acdemicWork));
        setAcademicWork(acdemicWork, subjectToChange);
        setCollection(new ApaCitationCollection(collection));
        setVolume(new ApaVolume(volume));
        setIssueName(new ApaIssueName(issueName));
        setPubDate(new ApaCitationDate(pubDate, acdemicWork));
        setPublisher(new ApaPublisher(publisher));
        setLocation(new ApaLocation(location));
        setAccessDate(new ApaAccessDate(accessDate));
    }

    public boolean isAcademicWork() {
        return mode == ACADEMIC_WORK;
    }

    // MODIFIES: this
    // EFFECTS: if academicWork set mode to academic work
    //          otherwise set it to webpage(subject to change) if subjectToChange, or webpage otherwise;
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
