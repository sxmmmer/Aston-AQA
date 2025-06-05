package org.sxmmer.Task_1;

class Dog extends Animal {
    public static int dogCount = 0;
    private String name;

    public Dog(String name) {
        this.name = name;

        dogCount++;
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
