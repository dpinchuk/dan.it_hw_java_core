package homework_7;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String species;
    private String nickname;
    private byte age;
    private byte trickLevel;
    private String[] habits;

    static {
        System.out.println("Loading class [" + Pet.class + "]");
    }

    /**
     * Constructor for pet
     *
     * @param species
     * @param nickname
     * @param age
     * @param trickLevel
     * @param habits
     */
    public Pet(String species, String nickname, byte age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        {
            System.out.println("Creating new oblect [" + this + "]");
        }
    }

    /**
     *
     * @param species
     * @param nickname
     */
    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
        {
            System.out.println("Creating new oblect [" + this + "]");
        }
    }

    /**
     * Empty constructor
     */
    public Pet() {
    }

    /**
     * void method  eat
     */
    public void eat() {
        System.out.println("Я кушаю!");
    }

    /**
     * void method  respond
     */
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + this.nickname + ". Я соскучился!");
    }

    /**
     * void method  foul
     */
    public void foul() {
        System.out.println("Мною испорчен новый ковер =))). Нужно хорошо замести следы...");
    }

    /**
     * @return string (this.species)
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species setter
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return string (this.getNickname)
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname setter
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return byte (this.getAge)
     */
    public byte getAge() {
        return age;
    }

    /**
     * @param age setter
     */
    public void setAge(byte age) {
        this.age = age;
    }

    /**
     * @return byte (this.getTrickLevel)
     */
    public byte getTrickLevel() {
        return trickLevel;
    }

    /**
     * @param trickLevel setter
     */
    public void setTrickLevel(byte trickLevel) {
        this.trickLevel = trickLevel;
    }

    /**
     * @return string (this.getHabits)
     */
    public String[] getHabits() {
        return habits;
    }

    /**
     * @param habits String[]
     */
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    /**
     * @return this
     */
    @Override
    public String toString() {
        return this.species + "{" +
                "nickname='" + this.nickname + "'" +
                ", age=" + this.age +
                ", trickLevel=" + this.trickLevel +
                (this.habits != null ? ", habits=" + Arrays.toString(this.habits) : "") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) &&
                Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }

}