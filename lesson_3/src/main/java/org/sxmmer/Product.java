package org.sxmmer;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate date;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isReserved;

    public Product(String name, LocalDate date, String manufacturer, String country, double price, boolean isReserved){
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void info(){
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + "$");
        System.out.println("Состояние бронирования покупателем: " + (isReserved ? "Забронирован":"Не забронирован"));
        System.out.println();
    }

    public static void main(String[] args){
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(
                "Электрогитара Fender Stratocaster",
                LocalDate.of(2023, 9, 15),
                "Fender Musical Instruments Corporation",
                "США",
                1249.99,
                false);
        productsArray[1] = new Product(
                "Синтезатор Yamaha PSR-E373",
                LocalDate.of(2024, 2, 10),
                "Yamaha Corporation",
                "Япония",
                349.99,
                true);
        productsArray[2] = new Product(
                "Барабанная установка Pearl Export",
                LocalDate.of(2022, 11, 5),
                "Pearl Corporation",
                "Китай",
                979.99,
                false);
        productsArray[3] = new Product(
                "Саксофон Yamaha YAS-280",
                LocalDate.of(2023, 7, 1),
                "Yamaha Corporation",
                "Япония",
                869.99,
                true);
        productsArray[4] = new Product(
                "Скрипка Stentor Student II 4/4",
                LocalDate.of(2023, 3, 12),
                "Stentor Music Co Ltd",
                "Китай",
                299.99,
                true);
        for (Product product : productsArray){
            product.info();
        }
    }
}
