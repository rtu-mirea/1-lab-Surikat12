package lab;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Scanner in;
    private static EffectiveProductionSystem system;

    public static void main(String[] args) {
        system = new EffectiveProductionSystem();
        system.addUser("admin", "admin", "admin", "admin", 1);
        in = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {

            System.out.println("\nВыберите функцию");
            System.out.println("1. Войти в систему");
            System.out.println("2. Зарегистрироваться");
            System.out.println("3. Добавить оборудование");
            System.out.println("4. Добавить заказ");
            System.out.println("5. Составить план загрузки оборудования");
            System.out.println("6. Выход");

            choice = in.nextInt();
            switch (choice) {
                case 1:
                    signIn();
                    break;

                case 2:
                    signUp();
                    break;

                case 3:
                    addInstrument();
                    break;

                case 4:
                    addRequest();
                    break;

                case 5:
                    processRequests();
                    break;
            }
        }
        in.close();
    }

    private static void signIn() {
        System.out.println("\nВведите логин");
        in.nextLine();
        String login = in.nextLine();
        System.out.println("Введите пароль");
        String password = in.nextLine();
        if (system.signIn(login, password)) {
            System.out.println("Вход успешно выполнен");
        } else {
            System.out.println("Неверный логин или пароль");
        }
    }

    private static void signUp() {
        System.out.println("\nВведите имя");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Введите логин");
        String login = in.nextLine();
        System.out.println("Введите пароль");
        String password = in.nextLine();
        System.out.println("Повторите пароль");
        String repetition = in.nextLine();
        try {
            system.addUser(name, login, password, repetition, 0);
            System.out.println("Регистрация успешна");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            signUp();
        }
    }

    private static void addInstrument() {
        System.out.println("\nВведите название инструмента");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Введите количество инструмента");
        int count = in.nextInt();
        try {
            system.addInstrument(name, count);
            System.out.println("Добавление инструмента успешно");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addInstrument();
        }
    }

    private static void addRequest() {
        LinkedList<RequestPart> parts = new LinkedList<>();
        System.out.println("\nВведите количество частей заказа");
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("\nВведите время части заказа");
            int time = in.nextInt();
            System.out.println("\nВведите название инструмента, необходимого для выполнения части заказа");
            in.nextLine();
            String name = in.nextLine();
            System.out.println("\nВведите количество данных инструментов, необходимого для выполнения части заказа");
            in.nextInt();
            try {
                parts.add(new RequestPart(new Instrument(name, count), time));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        try {
            system.addRequest(parts);
            System.out.println("Добавление заказа успешно");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processRequests() {
        system.processRequests();
        System.out.println("\n Оптимизация выполнена");
    }
}
