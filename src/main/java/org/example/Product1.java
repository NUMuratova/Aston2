package org.example;

import java.time.LocalDate;

public class Product1 {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String Country;
    private double price;
    private boolean reserved;

    public Product1 (String name, LocalDate productionDate, String manufacturer,
                     String Country, double price, boolean reserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.Country = Country;
        this.price = price;
        this.reserved = reserved;
    }

    public void printInfo() {
        System.out.println("Название товара:" + name);
        System.out.println("Дата производства:" + productionDate);
        System.out.println("Производитель:" + manufacturer);
        System.out.println("Страна происхождения:" + Country);
        System.out.println("Цена:" + price + "руб.");
        if (reserved) {
            System.out.println("Товар забронирован покупателем");
        } else {
            System.out.println("Товар не забронирован покупателем");
        }
    }
}

class MainProduct {
    public static void main(String[] args) {
        Product1 product1 = new Product1("Чай", LocalDate.of(2023, 8, 1),
        "ООО \"Чайный дом\"", "Индонезия", 500, true);
        product1.printInfo();
    }
}