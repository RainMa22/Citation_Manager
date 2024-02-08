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
    protected String[] inputTemplate;
    protected String[] outputTemplate;
    protected String head;
    protected String tail;
    protected int mode;
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
        mode = INACTIVE;
        inputTemplate = new String[]{"yyyy", "yyyy-MM", "yyyy-MM-dd"};
        for (int i = 2; i >= 0; i -= 1) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(inputTemplate[i]);
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

    // EFFECTS: converts the Date to a citation String;
    @Override
    public String toString() {
        if (mode == INACTIVE) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(outputTemplate[mode]);
        return head.concat(dateFormat.format(date)).concat(tail);
    }
}
