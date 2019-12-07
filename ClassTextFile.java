package lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ClassTextFile {
    private String path;

    public ClassTextFile(String path) {
        this.path = path;
        File file = new File(path);
        if (file.exists())
            System.out.println("Файл с именем " + file.getName() + " существует");
    }

    public Instrument getWorker() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File(path)));
        String name = sc.nextLine();
        int count = sc.nextInt();

        sc.close();
        return new Instrument(name, count);
    }
}