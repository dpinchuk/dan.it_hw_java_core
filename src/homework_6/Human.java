package homework_6;

import java.util.Arrays;
import java.util.Objects;

/*
 * Entity class of humans (parents & children)
 *
 * @author Dmitry Pinchuk
 * */
public class Human {

    private String name;
    private String surname;
    private short year;
    private byte iq;
    private Family family;
    private String[][] schedule;

    /**
     * First full constructor for children
     *
     * @param name
     * @param surname
     * @param year
     * @param iq
     */
    public Human(String name, String surname, short year, byte iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    /**
     * Empty constructor
     */
    public Human() {
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", year=" + this.year +
                ", iq=" + this.iq +
                (this.family != null ? ", family='" + this.family + "'" : "") +
                (this.schedule != null ? ", schedule=" + Arrays.deepToString(this.schedule) : "") +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public byte getIq() {
        return iq;
    }

    public void setIq(byte iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return this.family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

}