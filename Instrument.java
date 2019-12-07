package lab;

import java.io.Serializable;

public class Instrument implements Serializable {
    private String name;
    private int count;

    Instrument(String name, int count) throws IllegalArgumentException {
        this.name = name;
        if (count < 0) {
            throw new IllegalArgumentException("Отрицательное значение количества");
        }
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException("Отрицательное значение количества");
        }
        this.count = count;
    }

    @Override
    public String toString() {
        return "{Имя: " + name + " Количество: " + count + "}";
    }
}
