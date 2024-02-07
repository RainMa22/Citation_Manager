package util;

/*
 * Sanitizer for String
 * */
public class StringSanitizer {

    //EFFECTS: returns a String with no leading or ending spaces, and no double spaces, based on the inputted string
    public static String sanitizeString(String str) {
        String out = str.trim();
        out = removeDuplicate(out, " ");
        return out;
    }

    //EFFECTS: remove duplicating pattern of specified tailing string
    public static String removeDuplicate(String original, String toRemove) {
        String out = original;
        while (out.contains(toRemove.repeat(2))) {
            out = out.replace(toRemove.repeat(2), toRemove);
        }
        return out;
    }
}
