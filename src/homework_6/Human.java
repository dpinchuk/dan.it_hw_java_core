package homework_6;

import java.util.Arrays;
import java.util.Random;

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
    private Human mother;
    private Human father;
    private Family family;
    private Pet pet;
    private String[][] schedule;

    /**
     * First full constructor for children
     *
     * @param name
     * @param surname
     * @param year
     * @param iq
     * @param mother
     * @param father
     */
    public Human(String name, String surname, short year, byte iq, Human mother, Human father, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.mother = mother;
        this.father = father;
        this.pet = pet;
    }

    /**
     * Empty constructor
     */
    public Human() {
    }

    /**
     * @return this as String
     */
    @Override
    public String toString() {
        return "Human{" +
                (this.name != null ? ", name = '" + '\'' + this.name : "") +
                (this.surname != null ? ", surname = '" + '\'' + this.surname : "") +
                (this.year != 0 ? ", year = " + this.year : "") +
                (this.iq != 0 ? ", iq = " + this.iq : "") +
                (this.schedule != null ? "schedule = " + Arrays.deepToString(this.schedule) : "") +
                (this.family != null ? "family = " + this.family : "") +
                (this.pet != null ? "pet = " + this.pet : "") +
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

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * void method  greet pet
     */
    public void greetPet() {
        System.out.println("Здравствуй, " + this.pet.getNickname() + "!");
    }

    /**
     * void method  describe pet
     */
    public void describePet() {
        System.out.println(
                "У меня есть любимец " + this.pet.getSpecies() + ", " +
                        "ему " + this.pet.getAge() + " лет, " +
                        "он " + (this.pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый"));
    }

    /**
     * boolean method for feed the pet
     *
     * @param isItTimeToFeed is it time to feet the pet?
     * @return boolean
     */
    public boolean feedPet(boolean isItTimeToFeed) {
        if (isItTimeToFeed) {
            System.out.println("'" + this.pet.getNickname() + "' накормлен!");
            return true;
        } else {
            Random random = new Random();
            if (random.nextInt(101) < this.pet.getTrickLevel()) {
                System.out.println("Иду кормить '" + this.pet.getNickname() + "'");
                return true;
            }
        }
        System.out.println("Надеюсь, что '" + this.pet.getNickname() + "' не голоден.");
        return false;
    }


}