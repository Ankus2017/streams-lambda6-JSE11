/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package lambda01.examples;

import util.ExampleData;
import util.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample02 {



    // Print the products that cost less than the price limit.
    /*
    static void printProducts(List<Product> products, BigDecimal priceLimit) {
        for (Product product : products) {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        printProducts(products, priceLimit);
    }

     */
    interface ProductFilter{
        boolean accept(Product product);
    }

    static void printProducts(List<Product> products, ProductFilter filter){
        for (Product product: products){
            if(filter.accept(product)){
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args){
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("3.0");

        ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0;
        printProducts(products, filter);
    }
}
