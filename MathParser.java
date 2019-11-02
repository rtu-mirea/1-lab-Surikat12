package lab;
import java.util.ArrayList;
import java.util.HashMap;

public class MathParser {
    private static String[] convertorFuncs = {"Integer.parseInt", "Short.parseShort", "Double.parseDouble",
            "Long.parseLong", "Byte.parseByte", "Float.parseFloat"};
    public String text;

    MathParser() {
        text = "";
    }

    MathParser(String text) {
        this.text = text;
    }

    public boolean mathIsImport() {
        return text.contains("import java.lang.Math") || text.contains("import java.lang.*");
    }

    public ArrayList<String> mathFuncs() {
        ArrayList<String> res = new ArrayList<>();
        int startIndex = text.indexOf("Math.", 0);
        int endIndex;
        while (startIndex != -1) {
            endIndex = startIndex;
            while (text.charAt(endIndex) != '(') {
                endIndex++;
            }
            res.add(text.substring(startIndex, endIndex));
            startIndex = text.indexOf("Math.", endIndex + 1);
        }
        return res;
    }

    public HashMap<String, String> vars() {
        HashMap<String, String> foundVars = new HashMap<>();
        String temp = text.trim();
        for (String line: temp.split("\n")) {
            String[] words = line.trim().split(" ");
                if (words.length == 2 && !words[0].equals("package") && !words[0].equals("import") && words[1].charAt(words[1].length() - 1) == ';') {
                    foundVars.put(words[1].substring(0, words[1].length() - 1), words[0]);
                }
                if (words.length >= 3 && words[2].equals("=")) {
                    foundVars.put(words[1], words[0]);
                }
        }
        HashMap<String, String> res = new HashMap<>();
        for (String var: foundVars.keySet()) {
            for (String line: temp.split("\n")) {
                String[] words = line.trim().split(" ");
                if (words.length >= 3 && words[0].equals(var) && words[1].equals("=") && words[2].contains("(")) {
                    res.put(var, foundVars.get(var));
                    break;
                }
                if (words.length >= 4 && words[0].equals(foundVars.get(var)) && words[1].equals(var) && words[2].equals("=") && words[3].contains("(")) {
                    res.put(var, foundVars.get(var));
                    break;
                }
            }
        }
        return res;
    }

    public HashMap<String, ArrayList<Integer>> convertors() {
        HashMap<String, ArrayList<Integer>> res = new HashMap<>();
        int index;
        for (String func : convertorFuncs) {
            index = text.indexOf(func);
            while (index != -1) {
                if (!res.containsKey(func)) {
                    res.put(func, new ArrayList<>());
                }
                res.get(func).add(index);
                index = text.indexOf(func, index + func.length());
            }
        }
        return res;
    }
}
