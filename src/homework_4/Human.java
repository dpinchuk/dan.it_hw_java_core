package homework_4;

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
     * Second limited constructor for parents
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
            System.out.println("'" + this.pet.getNickname() + "' накормлен!");
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
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", year=" + this.year +
                ", iq=" + this.iq +
                (this.mother != null ? ", mother=" + this.mother.name + " " + this.mother.surname : "") +
                (this.father != null ? ", father=" + this.father.name + " " + this.father.surname : "") +
                (this.pet != null ? ", pet=" + this.pet : "") +
                '}';
    }

}