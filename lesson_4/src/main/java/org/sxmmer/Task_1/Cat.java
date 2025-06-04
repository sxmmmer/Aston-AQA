package org.sxmmer.Task_1;

class Cat extends Animal {
    public static int catCount = 0;
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name) {
        this.name = name;
        this.satiety = false;

        catCount++;
    }

    public void eat(Bowl bowl, int appetite) {
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
