package lab;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Первое задание:");
        Task1.execute();

        System.out.println("\n\nВторое задание:");
        task2();

        System.out.println("\n\nТретье задание:");
        Task3.execute();

        System.out.println("\n\nЧетвёртое задание:");
        task4();
    }

    public static void task2() {
        try {
            Scanner in = new Scanner(System.in);
            FileManager manager = new FileManager("movies.txt");

            System.out.println("Запись объекта в файл:");
            System.out.println("Введите название фильма");
            String name = in.nextLine();
            System.out.println("Введите название студии");
            String studio = in.nextLine();
            System.out.println("Введите имя режиссёра");
            String producer = in.nextLine();
            System.out.println("Введите имя исполнителя главной роли");
            String actor = in.nextLine();
            System.out.println("Введите год выхода фильма");
            int year = in.nextInt();
            manager.write(name, studio, producer, actor, year);

            for (int i = 0; i < 2; i++) {
                System.out.println("Запись объекта в файл:");
                System.out.println("Введите название фильма");
                in.nextLine();
                name = in.nextLine();
                System.out.println("Введите название студии");
                studio = in.nextLine();
                System.out.println("Введите имя режиссёра");
                producer = in.nextLine();
                System.out.println("Введите имя исполнителя главной роли");
                actor = in.nextLine();
                System.out.println("Введите год выхода фильма");
                year = in.nextInt();
                manager.write(name, studio, producer, actor, year);
            }

            LinkedList<Movie> movies = manager.getMovies();
            System.out.println("Фильмы с одинаковыми авторами:");
            System.out.println(movies.toString());

            manager.writeRAF(movies);

            System.out.println("Получение исполнителя главной роли по названию фильма: ");
            in.nextLine();
            name = in.nextLine();
            System.out.println(manager.getActor(name));

            System.out.println("Определить, созданы ли два фильма одним режиссёром");
            System.out.println("Первый фильм: ");
            String name1 = in.nextLine();
            System.out.println("Второй фильм: ");
            String name2 = in.nextLine();
            System.out.println(manager.oneProducer(name1, name2));

            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task4() {
        try {
            ClassTextFile textFile = new ClassTextFile("task4_text_file.txt");
            System.out.println("Получение объекта из файла");
            Instrument instrument1 = textFile.getWorker();
            System.out.println(instrument1);

            ClassSerializableFile ser = new ClassSerializableFile("task4_ser.txt");
            ser.writeObject(instrument1);

            System.out.println("Десериализация объекта");
            System.out.println(ser.readObject());

            Scanner in = new Scanner(System.in);
            System.out.println("Сериализация листа объектов");
            System.out.println("Введите название инструмента");
            String name = in.nextLine();
            System.out.println("Введите количество инструмента");
            int count = in.nextInt();
            LinkedList<Instrument> instruments = new LinkedList<>();
            instruments.add(instrument1);
            instruments.add(new Instrument(name, count));
            ser.setInstruments(instruments);
            ser.writeList();

            System.out.println("Десериализация листа объектов");
            ser.readList();
            System.out.println(ser.getInstruments());

            in.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
