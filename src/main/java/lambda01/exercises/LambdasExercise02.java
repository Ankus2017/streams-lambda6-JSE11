/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package lambda01.exercises;

import util.Category;
import util.Product;

import java.util.ArrayList;
import java.util.List;

public class LambdasExercise02 {

    public interface ProductFilter {
        boolean accept(Product product);
    }

    /**
     * Exercise 2: Find products by category by implementing a functional interface using a lambda expression and calling it.
     *
     * @param products The list of products to search.
     * @param category The category of products to search for.
     * @return A new list containing the products which are in the specified category.
     */
    public List<Product> findProductsByCategory(List<Product> products, Category category) {
        // TODO: Implement interface ProductFilter with a lambda expression
        // The lambda expression should return true if the product is in the given category
        ProductFilterCategory filter = product -> product.getCategory() == category;

        List<Product> result = new ArrayList<>();
        for (Product product : products) {
                if(filter.accept(product)){
                    result.add(product);
                }
            // TODO: Add products that are accepted by the filter to the 'result' list
        }

        return result;
    }

    interface ProductFilterCategory {
        boolean accept(Product product);
    }
}
