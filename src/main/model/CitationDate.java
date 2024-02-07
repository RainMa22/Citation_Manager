package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


// construct a date following a citation format
public abstract class CitationDate {
    public static final int YEAR_ONLY = 0;
    public static final int YEAR_AND_MONTH = 1;
    public static final int YEAR_MONTH_AND_DAY = 2;
    public static final int INACTIVE = -1;
    protected static final String[] INPUT_TEMPLATE = {"yyyy", "yyyy-MM", "yyyy-MM-dd"};
    private int mode;
    protected Date date;

    // constructor for CitationDate
    // EFFECTS: converts dateString using one of the input templates,
    //          if dateString follows "yyyy": set mode to YEAR_ONLY;
    //          if dateString follows "yyyy-MM": set mode to YEAR_AND_MONTH;
    //          if dateString follows "yyyy-MM-dd": set mode to YEAR_MONTH_AND_DAY;
    //          otherwise: set mode to Inactive
    public CitationDate(String dateString) {
        mode = INACTIVE;
        for (int i = 2; i >= 0; i -= 1) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(INPUT_TEMPLATE[i]);
                this.date = dateFormat.parse(dateString);
                mode = i;
                break;
            } catch (ParseException ignored) {
                //continue
            }
        }
    }

    public int getMode() {
        return mode;
    }

    public Date getDate() {
        return date;
    }

    // converts the Date to an option
    @Override
    public abstract String toString();
}
