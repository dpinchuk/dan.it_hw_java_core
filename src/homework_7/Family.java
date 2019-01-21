package homework_7;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family {

    private Human father;
    private Human mother;
    private static Human[] children;
    private Pet pet;

    static {
        System.out.println("Loading class [" + Family.class + "]");
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        {
            System.out.println("Creating new oblect [" + this + "]");
        }
    }

    static {
        children = new Human[0];
    }

    public Family(Human father, Human mother, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.pet = pet;
        {
            System.out.println("Creating new oblect [" + this + "]");
        }

    }

    public void addChild(Human child) {
        {
            System.out.println("Creating new oblect [" + this + "]");
        }
        if (this.children == null) {
            this.children = new Human[1];
        } else {
            Human[] arr = Arrays.copyOf(this.children, this.children.length + 1);
            this.children = Arrays.copyOf(arr, arr.length);
        }
        this.children[this.children.length - 1] = child;
        this.children[this.children.length - 1].setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (this.children.length >= index && index >= 0) {
            Human[] arrChildren = new Human[this.children.length - 1];
            int count = 0;
            for (int i = 0; i < index; i++) {
                arrChildren[count++] = this.children[i];
            }
            this.children[index].setFamily(null);
            for (int i = index + 1; i < this.children.length; i++) {
                arrChildren[count++] = this.children[i];
            }
            this.children = new Human[arrChildren.length];
            this.children = Arrays.copyOf(arrChildren, arrChildren.length);
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        for (int i = 0; i <= this.children.length; i++) {
            if (isEqualChild(child, this.children[i])) {
                deleteChild(i);
                return true;
            }
        }
        return false;
    }

    public int countFamily() {
        return (2 + this.children.length);
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

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Family getFamily() {
        return this;
    }

    @Override
    public String toString() {
        return "Family{" +
                "father=" + this.father +
                ", mother=" + this.mother +
                (this.children != null ? ", children=" + this.children : "") +
                ", pet=" + this.pet +
                '}';
    }

    private boolean isEqualChild(Human seekChild, Human child) {
        if (seekChild.equals(child) && seekChild.hashCode() == child.hashCode()) {
            return true;
        }
        return false;
    }

    public Human[] getChildren() {
        return this.children;
    }

    public void printChildren() {
        System.out.println("Children:");
        for (Human c : this.children) {
            System.out.println(c);
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) &&
                Objects.equals(mother, family.mother) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(father, mother, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

}