package lab;
import java.io.*;
import java.nio.charset.Charset;


public class Task3 {

    public static void execute() {
        exercise1();
        exercise2();
        exercise3();
    }

    public static void exercise1() {
        try {
            FileReader reader = new FileReader("T1.txt");
            FileWriter writer = new FileWriter("T2.txt");

            int x;
            while ((x = reader.read()) != -1) {
                writer.write((char) x);
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exercise2() {
        try {
            File file = new File("A.txt");
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader in = new BufferedReader(fileReader, 128);

            File file2 = new File("B.txt");
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2);
            BufferedWriter out = new BufferedWriter(fileWriter, 128);

            char[] buf = new char[128];
            for(int i = 0, j = 0; i < file.length(); i++, j++) {
                if(j == buf.length) {
                    j = 0;
                    out.write("\n");
                }
                buf[j] = (char)in.read();
                out.write(buf[j]);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exercise3() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C.txt"), "UTF-8"));
            System.out.println("Кодировка, действующая в системе: " + Charset.defaultCharset().name());

            String buf = "";
            int x;
            while ((x = in.read()) != -1) {
                buf += (char) x;
            }
            System.out.println(buf);

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
