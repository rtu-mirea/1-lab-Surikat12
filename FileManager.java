package lab;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;


public class FileManager {
    DataOutputStream out;
    DataInputStream in;
    RandomAccessFile raf;
    File file;
    int stringSize = 64;


    public FileManager(String fileName) throws IOException {
        file = new File(fileName);
        if (file.exists())
            System.out.println("Файл с именем " + file.getName() + " существует");
        else {
            file.createNewFile();
            System.out.println("Файл с именем " + file.getName() + " создан");
        }
        out = new DataOutputStream(new FileOutputStream(file));
        in = new DataInputStream(new FileInputStream(file));
        raf = new RandomAccessFile("RAF_" + file, "rw");
    }

    public void write(String name, String studio, String producer, String actor, int year) throws IOException {
        writeStr(name);
        writeStr(studio);
        writeStr(producer);
        writeStr(actor);
        out.writeInt(year);
    }

    private void writeStr(String str) throws IOException {
        out.writeInt(str.getBytes().length);
        out.writeBytes(str);
    }

    private String readStr() throws IOException {
        int size = in.readInt();
        byte[] str = new byte[size];
        in.read(str);
        return new String(str);
    }

    public LinkedList<Movie> getMovies() throws IOException {
        LinkedList<Movie> res = new LinkedList<>();
        String commonProducer = "";

        if (in.available() > 0) {
            String name = readStr();
            String studio = readStr();
            commonProducer = readStr();
            String actor = readStr();
            int year = in.readInt();
            res.add(new Movie(name, studio, commonProducer, actor, year));
        }

        while (in.available() > 0) {
            String name = readStr();
            String studio = readStr();
            String producer = readStr();
            String actor = readStr();
            int year = in.readInt();

            if (producer.equals(commonProducer)) {
                res.add(new Movie(name, studio, producer, actor, year));
            }
        }

        return res;
    }

    public byte[] fillStr(String str) {
        int strSize = str.getBytes().length;
        byte[] res = Arrays.copyOf(str.getBytes(), stringSize);
        for (int i = strSize; i < stringSize; i++) {
            res[i] = 32;
        }
        return res;
    }

    public void writeRAF(LinkedList<Movie> movies) throws IOException {
            raf.setLength(0);
            for (Movie movie : movies) {
                raf.write(fillStr(movie.getName()));
                raf.write(fillStr(movie.getStudio()));
                raf.write(fillStr(movie.getProducer()));
                raf.write(fillStr(movie.getActor()));
                raf.writeInt(movie.getYear());
            }
    }

    public String getActor(String name) throws IOException {
        int size = (int) new File("RAF_" + file).length();
        byte[] str = new byte[stringSize];

        raf.seek(0);
        while (raf.getFilePointer() < size) {
            raf.read(str);
            if ((new String(str)).trim().equals(name)) {
                raf.skipBytes(2*stringSize);
                raf.read(str);
                return (new String(str)).trim();
            }
            raf.skipBytes(3*stringSize + 4);
        }
        return "Фильма с названием " + name + " не обнаружено";
    }

    public boolean oneProducer(String name1, String name2) throws IOException {
        int size = (int) new File("RAF_" + file).length();
        byte[] str = new byte[stringSize];
        String producer1 = null;
        String producer2 = null;

        raf.seek(0);
        while (raf.getFilePointer() < size) {
            raf.read(str);
            String name = (new String(str)).trim();
            if (name.equals(name1)) {
                raf.skipBytes(stringSize);
                raf.read(str);
                producer1 = (new String(str)).trim();
                raf.skipBytes(stringSize + 4);
            }
            else if (name.equals(name2)) {
                raf.skipBytes(stringSize);
                raf.read(str);
                producer2 = (new String(str)).trim();
                raf.skipBytes(stringSize + 4);
            }
            else {
                raf.skipBytes(3*stringSize + 4);
            }
        }

        return producer1 != null && producer1.equals(producer2);
    }
}