package lab;


public class Movie {
    String name;
    String studio;
    String producer;
    String actor;
    int year;

    Movie(String name, String studio, String producer, String lastName, int year) {
        this.name = name;
        this.studio = studio;
        this.producer = producer;
        this.actor = lastName;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getActor() {
        return actor;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public String getStudio() {
        return studio;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "Название фильма: " + name+
                " Студия: " + studio +
                " Режиссёр: " + producer +
                " Исполнитель главной роли: " + actor +
                " Год: " + year;
    }
}
