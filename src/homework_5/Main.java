package homework_5;

/**
 * Мини-проект "Счастливая семья" (продолжение)
 * Суть проекта: описание структуры семьи с учетом того, что у каждого человека есть кровные родственники,
 * а состав семьи может со временем меняться.
 */
public class Main {

    public static void main(String[] args) {

        /* cat Sonya */
        Pet myCat = new Pet("Cat", "Sonya", (byte) 8, (byte) 77, new String[]{"eat", "drink", "sleep", "walk"});
        myCat.respond();
        myCat.eat();
        myCat.foul();

        /* tiger Petruha */
        Pet myNewCat = new Pet();
        myNewCat.setSpecies("Tiger");
        myNewCat.setNickname("Petruha");
        myNewCat.setAge((byte)3);
        myNewCat.setTrickLevel((byte)99);
        myNewCat.respond();
        myNewCat.foul();
        myNewCat.eat();

        /*Petya Virus*/
        Human emptyHuman = new Human();
        System.out.println(emptyHuman);
        emptyHuman.setName("Petya");
        emptyHuman.setSurname("Virus");

        /*Karleone family*/
        Human father = new Human("Vitas", "Karleone", (short) 1978);
        System.out.println(father);

        Human mather = new Human("Janet", "Karleone", (short) 1985);
        System.out.println(mather);

        Human son = new Human("Michael", "Karleone", (short) 1999, (byte) 90, myCat, mather, father,
                new String[][]{
                        {"Sunday", "Girls!"},
                        {"Moday", "Java!"},
                        {"Tuesday", "C++"},
                        {"Wednesday", "C#"},
                        {"Thursday", "Pyton"},
                        {"Friday", "Beer!"},
                        {"Saturday", "Cinema!"}
                });

        System.out.println();
        son.greetPet();
        son.describePet();
        System.out.println(son);

        System.out.println();
        son.feedPet(false);

        /*Adams family*/
        Human gomes = new Human();
        gomes.setPet(new Pet("Spyder", "Lilit", (byte)12, (byte)100, new String[]{"drink blood", "bite"}));
        gomes.setName("Gomes");
        gomes.setSurname("Adams");
        gomes.setIq((byte) 0);
        gomes.setYear((short) 1012);

        /* и так далее..................................... Мне скучно этим заниматься)))*/
    }

}