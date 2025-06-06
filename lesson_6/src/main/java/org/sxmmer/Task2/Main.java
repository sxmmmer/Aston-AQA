package org.sxmmer.Task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Мурашов", "483-23-43");
        phoneBook.add("Денисов", "893-04-12");
        phoneBook.add("Соммер", "391-34-23");

        System.out.println("Номера Мурашова: " + phoneBook.get("Мурашов"));
        System.out.println("Номера Денисова: " + phoneBook.get("Денисов"));
        System.out.println("Номера Соммера: " + phoneBook.get("Соммер"));
    }
}
