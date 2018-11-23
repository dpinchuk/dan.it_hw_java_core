package homework_4;

/**
 * Мини-проект "Счастливая семья"
 * Суть проекта: описание структуры семьи с учетом того, что у каждого человека есть кровные родственники,
 * а состав семьи может со временем меняться.
 * До прохождения темы "Коллекции" все домашние задания должны быть выполнены с использованием массивов
 * (НЕ используйте интерфейсы List, Set, Map, пока об этом не будет прямо сказано в задании).
 */
public class Main {

    public static void main(String[] args) {
        Pet myCat = new Pet("Cat", "Sonya", (byte) 8, (byte) 77, new String[]{"eat", "drink", "sleep", "walk"});
        myCat.respond();
        myCat.eat();
        myCat.foul();
        //System.out.println(myCat);

        Human father = new Human("Vito", "Karleone", (short) 1978, (byte) 80);
        Human mather = new Human("Jane", "Karleone", (short) 1985, (byte) 85);
        Human son = new Human("Michael", "Karleone", (short) 1999, (byte) 90, myCat, mather, father,
                new String[][]{
                        {"Sunday", "girls!"},
                        {"Moday", "Java!"},
                        {"Tuesday", "C++"},
                        {"Wednesday", "C#"},
                        {"Thursday", "Pyton"},
                        {"Friday", "beer!"},
                        {"Saturday", "Cinema!"}
                });

        System.out.println();
        son.greetPet();
        son.describePet();
        System.out.println(son);

        System.out.println();
        son.feedPet(false);
    }

}