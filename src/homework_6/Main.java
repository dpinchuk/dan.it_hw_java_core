package homework_6;

public class Main {

    public static void main(String[] args) {

        Human father1 = new Human("Ivan", "Ivanoff", (short) 1970, (byte) 80);
        Human mother1 = new Human("Ivanna", "Ivanoffa", (short) 1975, (byte) 85);
        Family family1 = new Family(father1, mother1, new Pet("dog", "Rex"));

        Human child11 = new Human("Petya", "Ivanoff", (short) 1995, (byte) 70);
        Human child12 = new Human("Julia", "Ivanoffa", (short) 1997, (byte) 77);
        Human child13 = new Human("Luna", "Ivanoffa", (short) 1999, (byte) 87);
        Human child14 = new Human("Miha", "Ivanoff", (short) 2000, (byte) 77);
        Human child15 = new Human("Sidney", "Ivanoffa", (short) 2000, (byte) 87);

        family1.addChild(child11);
        family1.addChild(child12);
        family1.addChild(child13);
        family1.addChild(child14);
        family1.addChild(child15);

        family1.deleteChild(1);
        family1.deleteChild(child14);

        System.out.println(family1.getFather());
        System.out.println(family1.getMother());
        family1.printChildren();
        System.out.println(family1.countFamily());

        System.out.println(family1);

        /*------------------------------------------------------------------------------------------------------------*/
        Human father2 = new Human("Boris", "Borisoff", (short) 1972, (byte) 82);
        Human mother2 = new Human("Liana", "Borisoffa", (short) 1975, (byte) 87);
        Family family2 = new Family(father2, mother2, new Pet("cat", "Bubble"));

        Human father3 = new Human("Sirius", "Vagner", (short) 1968, (byte) 89);
        Human mother3 = new Human("Inna", "Vagner", (short) 1976, (byte) 87);
        Family family3 = new Family(father3, mother3, new Pet("spider", "Ballot"));

    }

}