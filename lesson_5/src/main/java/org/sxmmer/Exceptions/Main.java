package org.sxmmer.Exceptions;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "x", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = arraySize(array);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static int arraySize(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Каждая строка массива должна содержать 4 элемента (строка " + i + ")");
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }
        return sum;
    }
}
