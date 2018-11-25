package homework_5;

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
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    /**
     * First full constructor for children
     *
     * @param name
     * @param surname
     * @param year
     * @param iq
     * @param pet
     * @param mother
     * @param father
     * @param schedule
     */
    public Human(String name, String surname, short year, byte iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    /**
     *
     * @param name
     * @param surname
     * @param year
     */
    public Human(String name, String surname, short year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    /**
     *
     * @param name
     * @param surname
     * @param year
     * @param mother
     * @param father
     */
    public Human(String name, String surname, short year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    /**
     * Empty constructor
     */
    public Human() {
    }

    /**
     * void method  greet pet
     */
    public void greetPet() {
        System.out.println("Привет, " + this.pet.getNickname() + "!");
    }

    /**
     * void method  describe pet
     */
    public void describePet() {
        System.out.println(
                "У меня есть " + this.pet.getSpecies() + ", " +
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
            System.out.println("'" + this.pet.getNickname() + "' поди накормлен!");
            return true;
        } else {
            Random random = new Random();
            if (random.nextInt(101) < this.pet.getTrickLevel()) {
                System.out.println("Хм... покормлю-ка я '" + this.pet.getNickname() + "'");
                return true;
            }
        }
        System.out.println("Думаю, '" + this.pet.getNickname() + "' не голоден.");
        return false;
    }

    /**
     * @return this as String
     */
    @Override
    public String toString() {
        return "Human{" +
                (this.name != null ? ", name='" + '\'' + this.name : "") +
                (this.surname != null ? ", surname='" + '\'' + this.surname : "") +
                (this.year != 0 ? ", year=" + this.year : "") +
                (this.iq != 0 ? ", iq=" + this.iq : "") +
                (this.mother != null ? ", mother=" + this.mother.name + " " + this.mother.surname : "") +
                (this.father != null ? ", father=" + this.father.name + " " + this.father.surname : "") +
                (this.pet != null ? ", pet=" + this.pet : "") +
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
}