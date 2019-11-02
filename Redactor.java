package lab;

public class Redactor {
    StringBuilder text;

    Redactor() {
        text = new StringBuilder();
    }

    Redactor(String text) {
        this.text = new StringBuilder(text);
    }

    public void include() {
        int index = text.indexOf(".");
        text.insert(index + 2, "Вставка ");
    }

    public void replaceNumbers() {
        int index, count;
        StringBuilder temp;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                index = i;
                count = 1;
                for (int j = index + 1; j < index + 4; j++) {
                    if (j < text.length() && Character.isDigit(text.charAt(j))) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 3) {
                    temp = new StringBuilder(text.substring(index, index + 3));
                    text.insert(index + 3, temp.reverse());
                    i += 6;
                }
            }
        }
    }

    public void add(String sentence) {
        text.append(" " + sentence);
    }

    public String toString() {
        return text.toString();
    }
}
