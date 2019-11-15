package lab;

public class RequestPart {
    private Instrument instrument;
    private int time;
    private int startTime;

    RequestPart(Instrument instrument, int time) throws IllegalArgumentException {
        if (instrument == null) {
            throw new IllegalArgumentException("Нулевая ссылка в качестве instrument");
        }
        this.instrument = instrument;
        if (time < 0) {
            throw new IllegalArgumentException("Отрицательное значение времени");
        }
        this.time = time;
        this.startTime = 0;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public int getTime() {
        return time;
    }

    public void setStartTime(int startTime) {
        if (startTime < 0) {
            throw new IllegalArgumentException("Отрицательное значение начального времени");
        }
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }
}
