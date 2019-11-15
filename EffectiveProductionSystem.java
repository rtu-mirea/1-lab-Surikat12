package lab;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class EffectiveProductionSystem {
    private LinkedList<User> users;
    private ArrayList<Request> requests;
    private ArrayList<Instrument> instruments;
    private User currentUser;

    EffectiveProductionSystem() {
        users = new LinkedList<>();
        requests = new ArrayList<>();
        instruments = new ArrayList<>();
        currentUser = null;
    }

    public void addUser(String name, String login, String password, String repetition, int type) throws IllegalArgumentException {
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                throw new IllegalArgumentException("Пользователь с таким логином уже есть");
            }
        }
        if (!password.equals(repetition)) {
            throw new IllegalArgumentException("Пароли не совпадают");
        }
        if (type == 0) { // 0 - клиент, остальное - админ
            users.add(new Client(name, login, password));
        } else {
            users.add(new Admin(name, login, password));
        }
    }

    public void addInstrument(String name, int count) throws IllegalArgumentException {
            instruments.add(new Instrument(name, count));
    }

    public void addRequest(LinkedList<RequestPart> parts) throws IllegalArgumentException {
        requests.add(new Request(parts));
    }

    private User findUser(String login, String password) {
        for (User user: users ) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        return null;
    }

    public boolean signIn(String login, String password) {
        currentUser = findUser(login, password);
        return currentUser != null;
    }

    public void processRequests() {
        Comparator<Request> comparator = new Comparator<>() {
            public int compare(Request request1, Request request2) {
                return request1.time() - request2.time();
            }
        };
        requests.sort(comparator);

        int startTime = 0;
        for (Request request: requests) {
            for (RequestPart part: request.getParts()) {
                part.setStartTime(startTime);
                startTime += part.getTime();
            }
        }
    }
}
