package homework_4;

import java.util.Arrays;

public class Pet {

    private String species;
    private String nickname;
    private byte age;
    private byte trickLevel;
    private String[] habits;

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
                ", habits=" + Arrays.toString(this.habits) +
                '}';
    }

}