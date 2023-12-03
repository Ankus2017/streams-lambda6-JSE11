package interfaces03.examples;

import interfaces03.Category;
import interfaces03.ExampleData;
import interfaces03.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;

public class InterfacesTypes {
    //Function interface take the value of Type T, and returns the value of type R
    //Used to transform values
    Function<Integer, String> functionInterface = new Function<Integer, String>() {
        @Override
        public String apply(Integer integer) {
            return "The value is "+ integer;
        }
    };

    //consumer Interface takes the value of type T, no return
    //used as a final step in a sequence of operations where the consumer does sth with the final result
    Consumer<String> consumerInterface = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };

    //Supplier is the opposite, takes no input but has one output
    //used as a factory method or with lazy initialisation
    Supplier<String> supplier = new Supplier<String>() {
        @Override
        public String get() {
            return "This is supplier";
        }
    };
    
    //Predicate takes one input and returns a boolean value
    Predicate<Product> predicate = new Predicate<Product>() {
        @Override
        public boolean test(Product product) {

            BigDecimal priceLimit =  new BigDecimal("3.0");

            return product.getPrice().compareTo(priceLimit) < 0;
        }
    };

    //UnaryOperator -> inout and output have the same type
    UnaryOperator<Product> unaryOperator = new UnaryOperator<Product>() {
        @Override
        public Product apply(Product product) {

                String name = product.getName().toUpperCase();
            return new Product(product.getCategory(), name, product.getPrice());
        }
    };

    /////////////////////////////////////////////////////////////
    //BiFunction interface has 2 inputs and 1 output
    BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {
        @Override
        public String apply(Integer integer, Integer integer2) {
            Integer sum = integer + integer2;
            return " The sum is " +sum;
        }
    };

    //BiConsumer has 2 inputs and no output
    BiConsumer<String, String> biConsumer = new BiConsumer<String, String>() {
        @Override
        public void accept(String s, String s2) {
            System.out.println(s + " " + s2);
        }
    };

    //Takes 2 inputs and returns boolean value
    BiPredicate<Integer, Integer> biPredicate = new BiPredicate<Integer, Integer>() {
        @Override
        public boolean test(Integer integer, Integer integer2) {
            Integer square = (int) Math.pow(integer, 2);
            return square == integer2;
        }
    };

    //Two inputs and one output all have the same type
    BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            Integer pow = (int) Math.pow(integer, integer2);

            return pow;
        }
    };






    public static void main(String[] args) {

        BinaryOperator<Integer> power = (a,b) -> (int) Math.pow(a, b);
        Integer result = power.apply(5,3);
        System.out.println(result);

        //Specialized interfaces fot int, long , double -> PrefixToSuffixInterface
        IntBinaryOperator root = (a,b) -> (int) Math.round(Math.pow(a, 1.0 / b));

        System.out.println(root.applyAsInt(125,3));


        //Map list of products to their categories
        List<Product> products = ExampleData.getProducts();

        productByCategory(products);
        productByCategoryCompute(products);



    }

    public static void productByCategory(List<Product> products){
        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        products.stream().forEach(product -> {
            if(productsByCategory.containsKey(product.getCategory())){
                List<Product> productCategory = productsByCategory.get(product.getCategory());
                productCategory.add(product);
            }else {
                List<Product> productList = new ArrayList<>();
                productList.add(product);
                productsByCategory.put(product.getCategory(), productList);
            }
        });

        productsByCategory.forEach((category, products1) -> {
            System.out.println(category);
            System.out.println(products1.toString());
        });
    }

    public static void productByCategoryCompute(List<Product> products){
        //using computeIfAbsent
        Map<Category, List<Product>> productsByCategory = new HashMap<>();
        for (Product product: products){
            Category category = product.getCategory();

            //if the entry exists it return the entry, if not it return new value
            productsByCategory.computeIfAbsent(category, c -> new ArrayList<>()).add(product);

        }

        productsByCategory.forEach(((category, products1) -> {
            System.out.println(category);
            products1.forEach(product -> System.out.println("- " + product.getName()));
        }));
    }




}
