package lab;

public class Instrument {
    private String name;
    private int count;

    Instrument(String name, int count) throws IllegalArgumentException {
        this.name = name;
        if (count < 0) {
            throw new IllegalArgumentException("Отрицательное значение количества");
        }
        this.count = count;
    }

    public void setName(String name) { //моё
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
