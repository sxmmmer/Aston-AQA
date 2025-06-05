package org.sxmmer.Task_1;

public class Bowl {
    private int amountOfFood;
    public Bowl(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void addFood(int food) {
        if (food > 0) {
            amountOfFood += food;
            System.out.println(food + " единиц еды добавлено в миску. Сейчас в миске: " + amountOfFood);
        } else {
            System.out.println("Нельзя добавить отрицательное или нулевое количество еды.");
        }
    }
}
