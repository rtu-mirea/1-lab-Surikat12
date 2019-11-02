package lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private static Pattern pattern = Pattern.compile("'\\d+'");

    public static boolean check(String text) {
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static String doubleNumbers(String text) {
        Matcher matcher = pattern.matcher(text);
        int start, end;
        int prevEnd = 0;
        String res = "";
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            res += text.substring(prevEnd, start + 1) + Integer.parseInt(text.substring(start + 1, end - 1)) * 2 + "'";
            prevEnd = end;
        }
        res += text.substring(prevEnd);
        return res;
    }
}
