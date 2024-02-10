package util;

import java.util.Arrays;
import java.util.List;

public class BooleanUtils {
    public static final List<String> POSITIVE_VALUES = Arrays.asList(new String[]{"yes", "true", "1", "t", "y"});
    public static final List<String> NEGATIVE_VALUES = Arrays.asList(new String[]{"no", "false", "0", "f", "n"});

    // EFFECTS: converts String to Boolean, accepts "yes", "true", "1", "y", "t" as true,
    //          and "no","false", "0", "n","f" as false
    //          Null if string is not in the selection;
    public static Boolean fromString(String str) {
        String lowerStr = str.trim().toLowerCase();
        if (POSITIVE_VALUES.contains(lowerStr)) {
            return true;
        } else if (NEGATIVE_VALUES.contains(lowerStr)) {
            return false;
        }
        return null;
    }
}
