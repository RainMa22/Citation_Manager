package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


// construct a date following a citation format
public abstract class CitationDate extends CitationComponent {
    public static final int YEAR_ONLY = 0;
    public static final int YEAR_AND_MONTH = 1;
    public static final int YEAR_MONTH_AND_DAY = 2;
    protected String[] inputTemplate;
    protected String[] outputTemplate;
    protected Date date;

    // constructor for CitationDate
    // EFFECTS: converts dateString using one of the input templates,
    //          if dateString follows "yyyy": set mode to YEAR_ONLY;
    //          if dateString follows "yyyy-MM": set mode to YEAR_AND_MONTH;
    //          if dateString follows "yyyy-MM-dd": set mode to YEAR_MONTH_AND_DAY;
    //          otherwise: set mode to Inactive
    public CitationDate(String dateString) {
        head = "";
        tail = "";
        outputTemplate = new String[0];
        setMode(INACTIVE);
        inputTemplate = new String[]{"yyyy", "yyyy-MM", "yyyy-MM-dd"};
        for (int i = 2; i >= 0; i -= 1) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(inputTemplate[i]);
                this.date = dateFormat.parse(dateString);
                setMode(i);
                break;
            } catch (ParseException ignored) {
                //continue
            } catch (NullPointerException npe) {
                break;
            }
        }
    }

    public Date getDate() {
        return date;
    }

    // EFFECTS: converts the Date to a citation String;
    @Override
    protected String createBody() {
        if (mode == INACTIVE || mode >= outputTemplate.length) {
            return "";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(outputTemplate[mode], Locale.CANADA);
            return dateFormat.format(date);
        }
    }
}
