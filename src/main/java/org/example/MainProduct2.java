package org.example;

import java.util.Arrays;

public class MainProduct2 {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung Galaxy S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro Max", "15.08.2025", "Apple Inc.", "USA", 9999, true);
        productsArray[2] = new Product("Xiaomi Mi Mix Fold 3", "20.03.2025", "Xiaomi Corporation", "China", 4999, true);
        productsArray[3] = new Product("OnePlus Ace Pro", "10.10.2025", "OnePlus", "China", 3999, true);
        productsArray[4] = new Product("Honor Magic V2", "05.09.2025", "Honor Device Company", "China", 6999, false);

        System.out.println(Arrays.toString(productsArray));
    }
}

class Product {
    private final String name;
    private final String releaseDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final int price;
    private final boolean inStock;

    public Product(String name, String releaseDate, String manufacturer, String countryOfOrigin, int price, boolean inStock) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}