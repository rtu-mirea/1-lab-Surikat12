package lab1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice = 0;
		int length;
		Scanner in = new Scanner(System.in);

		System.out.println("Введите количество элементов массива");
		length = in.nextInt();
		Array arr = new Array(length);

		while (choice != 6) {

			System.out.println("\nВыберите операцию");
			System.out.println("1. Заполнить массив вручную");
			System.out.println("2. Заполнить массив случайными числами");
			System.out.println("3. Вывести массив на экран");
			System.out.println("4. Проверить, что максимальное значение встретилось в массиве больше заданного значения");
			System.out.println("5. Упорядочить элементы массива по правилу");
			System.out.println("6. Выход");

			choice = in.nextInt();
			switch (choice) {
				case 1:
					arr.input();
					break;

				case 2:
					arr.random();
					break;

				case 3:
					System.out.println("Слева направо:");
					arr.lrout();
					System.out.println("\nСправа налево:");
					arr.rlout();
					break;

				case 4:
					System.out.println("Введите значение");
					int a = in.nextInt();
					System.out.println(arr.check(a));
					break;

				case 5:
					arr.ordering();
					System.out.println("Результат:");
					arr.lrout();
					break;

				case 6:
					break;

				default:
					System.out.println("Введено неверное значение");
					break;
			}
		}
	}
}