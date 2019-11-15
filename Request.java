package lab;
import java.util.LinkedList;

public class Request {
    private LinkedList<RequestPart> parts;

    Request() {
        parts = new LinkedList<>();
    }

    Request(LinkedList parts) throws IllegalArgumentException {
        if (parts == null) {
            throw new IllegalArgumentException("Нулевая ссылка в качестве parts");
        }
        this.parts = parts;
    }

    public void addPart(Instrument instrument, int time) {
        try {
            parts.add(new RequestPart(instrument, time));
        }
        catch (Exception e) {
            throw e;
        }
    }

    public LinkedList<RequestPart> getParts() {
        return parts;
    }

    public int time() {
        int res = 0;
        for (RequestPart part: parts) {
            res += part.getTime();
        }
        return res;
    }
}
