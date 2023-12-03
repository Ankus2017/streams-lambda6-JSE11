/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package lambda01.exercises;


import util.Product;

import java.util.List;

public class LambdasExercise01 {

    /**
     * Exercise 1: Sort a list of products by name using a lambda expression.
     *
     * @param products The list of products to sort.
     */
    public void sortProductsByName(List<Product> products) {
        // TODO: Use a lambda expression to sort the list of products by name
         products.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
        // products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

    }
}
