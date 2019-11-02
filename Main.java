package lab;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {

            System.out.println("\nВыберите задание");
            System.out.println("1. Задание 1 (String)");
            System.out.println("2. Задание 2 (StringBuilder)");
            System.out.println("3. Задание 3 (регулярные выражения)");
            System.out.println("4. Выход");

            choice = in.nextInt();
            switch (choice) {
                case 1:
                    task1();
                    break;

                case 2:
                    task2();
                    break;

                case 3:
                    task3();
                    break;
            }
        }
        in.close();
    }

    public static void task1() {
        int choice = 0;
        String text;
        try {
            text = Files.readString(Paths.get("code.txt"));
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
            return;
        }
        MathParser parser = new MathParser(text);

        while (choice != 5) {

            System.out.println("\nВыберите подзадание");
            System.out.println("1. Определить, была ли подключена библиотека математических функций");
            System.out.println("2. Сформировать список математических функций, используемых в программе");
            System.out.println("3. Сформировать список переменных, указав их тип, которым присваивалось вычисленное с помощью функций значение");
            System.out.println("4. Найти операторы, которые конвертируют строковые значения в числовой формат ");
            System.out.println("5. К выбору задания");

            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n" + parser.mathIsImport());
                    break;

                case 2:
                    System.out.println("\n" + parser.mathFuncs());
                    break;

                case 3:
                    System.out.println("\n" + parser.vars());
                    break;

                case 4:
                    System.out.println("\n" + parser.convertors());
                    break;
            }
        }
    }

    public static void task2() {
        int choice = 0;
        String text;
        System.out.println("Введите текст");
        in.nextLine();
        text = in.nextLine();
        Redactor redactor = new Redactor(text);

        while (choice != 4) {

            System.out.println("\nВыберите подзадание");
            System.out.println("1. Вставить слово \"Вставка\" перед первым словом второго предложения");
            System.out.println("2. Заменить все трехзначные числа шестизначными числами палиндромами, составленными из найденных трехзначных чисел");
            System.out.println("3. Добавить новое предложение в конец исходного текста");
            System.out.println("4. К выбору задания");

            choice = in.nextInt();
            switch (choice) {
                case 1:
                    redactor.include();
                    System.out.println("\n" + redactor);
                    break;

                case 2:
                    redactor.replaceNumbers();
                    System.out.println("\n" + redactor);
                    break;

                case 3:
                    System.out.println("\nВведите предложение");
                    in.nextLine();
                    text = in.nextLine();
                    redactor.add(text);
                    System.out.println("\n" + redactor);
                    break;
            }
        }
    }

    public static void task3() {
        int choice = 0;
        String text;

        while (choice != 3) {

            System.out.println("\nВыберите подзадание");
            System.out.println("1. Проверить, содержит ли строка целое число, заключённое в кавычки");
            System.out.println("2. Увеличить все числа в строке в кавычках в 2 раза");
            System.out.println("3. К выбору задания");

            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nВведите строку");
                    in.nextLine();
                    text = in.nextLine();
                    System.out.println(RegEx.check(text));
                    break;

                case 2:
                    System.out.println("\nВведите строку");
                    in.nextLine();
                    text = in.nextLine();
                    System.out.println(RegEx.doubleNumbers(text));
                    break;
            }
        }
    }
}
