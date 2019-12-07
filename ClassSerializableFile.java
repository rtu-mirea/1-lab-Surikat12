package lab;

import java.io.*;
import java.util.LinkedList;

public class ClassSerializableFile {
    private String path;
    private LinkedList<Instrument> instruments;

    public ClassSerializableFile(String path) {
        this.path = path;
    }

    public void setInstruments(LinkedList<Instrument> instruments) {
        this.instruments = instruments;
    }

    public void writeObject(Instrument instrument) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(instrument);

        out.close();
    }

    public Instrument readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Instrument res = (Instrument)in.readObject();

        in.close();
        return res;
    }

    public void writeList() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(instruments);

        out.close();
    }

    public void readList() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        instruments = (LinkedList<Instrument>)in.readObject();

        in.close();
    }

    public LinkedList<Instrument> getInstruments() {
        return instruments;
    }
}