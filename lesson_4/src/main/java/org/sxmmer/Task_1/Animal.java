package org.sxmmer.Task_1;

public class Animal {
    public static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м");
    }

    void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м");
    }
}
