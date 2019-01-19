package homework_6;

import java.util.Arrays;
import java.util.Random;

public class Family {

    private Human father;
    private Human mother;
    private Human[] children;
    private Pet pet;

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        children = new Human[]{};
        this.father.setFamily(this);
        this.mother.setFamily(this);
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChild(Human child) {
        this.children[this.children.length] = child;
        this.children[this.children.length - 1].setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (this.children.length < index) {
            Human[] arrChildrenFirst = new Human[]{};
            int count = 0;
            for (int i = 0; i < index; i++) {
                arrChildrenFirst[count++] = this.children[i];
            }
            arrChildrenFirst[index].setFamily(null);
            for (int i = index + 1; i < this.children.length; i++) {
                arrChildrenFirst[count++] = this.children[i];
            }
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        int index = 0;
        for (int i = 0; i <= this.children.length; i++) {
            if (this.children[i].getFamily().equals(child.getFamily()) &&
                    this.children[i].getName().equals(child.getName()) &&
                    this.children[i].getMother().equals(child.getMother()) &&
                    this.children[i].getFather().equals(child.getFather())) {
                this.deleteChild(index);
                return true;
            }
        }

        return false;
    }

    public int countFamily(Family family) {
        return (2 + family.children.length);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }
}