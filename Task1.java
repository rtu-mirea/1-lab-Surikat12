package lab;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;


public class Task1 {

    public static void execute() {
        try {
            // Упражнение 1
            File file1 = new File("MyFile1.txt");
            file1.createNewFile();

            File file2 = new File("E:\\MyFile2.txt");
            file2.createNewFile();

            File folder1 = new File("E:\\TestFolder");
            folder1.mkdir();

            File file3 = new File("E:\\TestFolder\\MyFile3.txt");
            file3.createNewFile();

            File folder2 = new File("Первая\\Вторая\\Третья");
            folder2.mkdirs();

            // Упражнение 2
            checkFile(file1);
            checkFile(file2);
            checkFile(file3);
            checkFile(folder2);

            checkFolder(file1);
            checkFolder(file2);
            checkFolder(file3);
            checkFolder(folder2);

            checkExictence(file1);

            absolutePath(file1);
            absolutePath(file2);
            absolutePath(file3);
            absolutePath(folder2);

            size(file1);
            size(file2);
            size(file3);
            size(folder2);

            // Упражнение 3
            File folder3 = new File("Папка");
            folder3.mkdir();

            File applicationFolder = new File(".");

            String[] content = applicationFolder.list();
            System.out.println("Список файлов:\n" + Arrays.toString(content));

            File[] contentFiles = applicationFolder.listFiles();
            System.out.println("Список файлов:\n" + Arrays.toString(contentFiles));

            File[] folders = applicationFolder.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
            System.out.println("Количество папок - " + folders.length);

            file1.delete();
            file2.delete();
            file3.delete();
            folder2.delete();
            folder1.delete();
            folder3.delete();
            folder2 = new File("Первая\\Вторая");
            folder2.delete();
            folder2 = new File("Первая");
            folder2.delete();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkFile(File file) {
        if (file.isFile()) {
            String name = file.getName();
            String parent = file.getParent();
            System.out.println(name + " - файл; родительская папка - " + parent);
        } else {
            String name = file.getName();
            System.out.println(name + " - не файл");
        }
    }

    public static void checkFolder(File file) {
        if (file.isDirectory()) {
            String name = file.getName();
            System.out.println(name + " - папка");
        } else {
            String name = file.getName();
            System.out.println(name + " - не папка");
        }
    }

    public static void checkExictence(File file ) {
        String name = file.getName();
        if (file.exists()) {
            System.out.println("В папке приложения существует файл " + name);
        }
        else {
            System.out.println("В папке приложения не существует файл" + name);
        }
    }

    public static void absolutePath(File file) {
        String name = file.getName();
        String path = file.getAbsolutePath();
        System.out.println("Полный путь к " + name + " - " + path);
    }

    public static void size(File file) {
        String name = file.getName();
        String type = "неизвестен";
        long size = file.length();
        if (file.isFile()) {
            type = "файл";
        }
        if (file.isDirectory()) {
            type = "папка";
        }
        System.out.println("Размер " + name + " - " + size + " байт. Тип - " + type);
    }
}
