package org.sxmmer.Task_1;

public class AllAnimals {
    public static void main(String[] args) {
        Dog baks = new Dog("Бакс");
        Cat[] catsArray = new Cat[2];
        catsArray[0] = new Cat("Мурзик");
        catsArray[1] = new Cat("Барсик");
        Bowl bowl = new Bowl(15);

        baks.run(300);
        baks.swim(15);
        catsArray[0].run(100);
        catsArray[1].swim(10);

        System.out.println();

        bowl.addFood(5);
        for (Cat cat : catsArray) {
            cat.eat(bowl, 10);
        }

        System.out.println();
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего собак: " + Dog.dogCount);
        System.out.println("Всего котов: " + Cat.catCount);
    }
}
