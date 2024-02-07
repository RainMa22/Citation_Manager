package util;

/*
* Sanitizer for String
* */
public class StringSanitizer {

    //EFFECTS: returns a String with no leading or ending spaces, and no double spaces, based on the inputted string
    public static String sanitizeString(String str) {
        String out = str.trim();
        while (out.contains("  ")) {
            out = out.replaceAll("  ", " ");
        }
        return out;
    }
}
