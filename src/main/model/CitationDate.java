package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


// construct a date following a citation format
public abstract class CitationDate extends CitationComponent {
    public static final int YEAR_ONLY = 0;
    public static final int YEAR_AND_MONTH = 1;
    public static final int YEAR_MONTH_AND_DAY = 2;
    public static final String[] INPUT_TEMPLATE = new String[]{"yyyy", "yyyy-MM", "yyyy-MM-dd"};
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
        for (int i = 2; i >= 0; i -= 1) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(INPUT_TEMPLATE[i]);
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

    // alternate constructor for CitationDate
    // EFFECTS: get date(from dateString), head, tail, mode, inputTemplate from JSONObject
    //          throws JSONException if dateString is ill-formed;
    //          if mode is inactive, skip trying to parse date;
    public CitationDate(JSONObject json) {
        super(json);
        List<Object> outputTemplateObj = json.getJSONArray("outputTemplate").toList();
        outputTemplate = new String[outputTemplateObj.size()];
        for (int i = 0; i < outputTemplateObj.size(); i++) {
            outputTemplate[i] = String.valueOf(outputTemplateObj.get(i));
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(INPUT_TEMPLATE[mode]);
            try {
                date = dateFormat.parse(json.getString("dateString"));
            } catch (ParseException e) {
                throw new JSONException(e);
            }
        } catch (IndexOutOfBoundsException ioobe) {
            date = null;
        }
    }

    public Date getDate() {
        return date;
    }

    // EFFECTS: converts the Date to a citation String;
    @Override
    protected String createBody() {
        if (mode == INACTIVE) {
            return "";
        } else if (mode >= outputTemplate.length) {
            return "";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(outputTemplate[mode], Locale.CANADA);
            return dateFormat.format(date);
        }
    }

    // returns JSONObject Representation of the AccessDate
    //         store head, tail, mode, outputTemplate(as JSONArray) and dateString (Date as from the inputTemplate)
    @Override
    public JSONObject asJson() {
        JSONObject out = super.asJson();

        out.put("dateString", getDateString());
        out.put("outputTemplate", new JSONArray(outputTemplate));

        return out;
    }

    // helper function for asJson()
    // EFFECTS: returns the date as a String following the input format;
    public String getDateString() {
        String[] temp = this.outputTemplate;
        this.outputTemplate = INPUT_TEMPLATE;
        String out = createBody();
        this.outputTemplate = temp;
        return out;
    }

    //getter for outputTemplate
    public String[] getOutputTemplate() {
        return outputTemplate;
    }
}
