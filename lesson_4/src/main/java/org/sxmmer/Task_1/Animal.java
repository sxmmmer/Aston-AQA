package org.sxmmer.Task_1;

public class Animal {
    private static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м");
    }

    void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м");
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private String name;

    public Dog(String name) {
        this.name = name;

        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    void run(int distance) {
        if (distance <= 500){
            System.out.println("Собака пробежала " + distance + " м");
        } else {
            System.out.println("Собака устала");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= 10){
            System.out.println("Собака проплыла " + distance + " м");
        } else {
            System.out.println("Собака устала");
        }
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;

        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(Bowl bowl) {
        if (appetite <= bowl.getAmountOfFood()) {
            satiety = true;
            System.out.println(name + " покушал и теперь сыт :)");
        } else {
            System.out.println(name + " не может покушать, потому что в миске нет столько еды и он остался голоден :(");
        }
    }

    @Override
    void run(int distance) {
        if (distance <= 200){
            System.out.println("Кот пробежал " + distance + " м");
        } else {
            System.out.println("Кот устал");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }
}
