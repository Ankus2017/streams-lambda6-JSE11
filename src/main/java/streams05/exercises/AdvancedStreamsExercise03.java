package streams05.exercises;

import util.Category;
import util.ExampleData;
import util.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExercise03 {

    public enum PriceRange {
        CHEAP, MEDIUM, EXPENSIVE
    }

    /**
     * Exercise 3: Group products by price range.
     *
     * @param products       A list of products.
     * @param cheapLimit     Products cheaper than this are considered cheap.
     * @param expensiveLimit Products more expensive than this are considered expensive.
     * @return A map containing the cheap, medium and expensive products in separate lists.
     */
    public Map<PriceRange, List<Product>> groupProductsByPriceRange(List<Product> products, BigDecimal cheapLimit, BigDecimal expensiveLimit) {
        // TODO: Group products by price range.
        //
        // - A product is CHEAP if its price is less than cheapLimit.
        // - A product is EXPENSIVE if its price is more than expensiveLimit.
        // - A product is MEDIUM if its price is between cheapLimit and expensiveLimit.
        //
        // Hint: Look carefully at the type of the keys of the map that this method should return. It tells you something about the classifier function.
        // What relation does this have with the classifier function that you use when using a grouping operation?

     //   Map<PriceRange, List<String>> priceRangeListMap = products.stream()
        //        .collect(Collectors.groupingBy(PriceRange.CHEAP,  Collectors.mapping(product -> product.getPrice().compareTo(cheapLimit) < 0), Collectors.toList()));

      List<Product> cheap =  products.stream().filter(product -> product.getPrice().compareTo(cheapLimit) < 0).collect(Collectors.toList());
        List<Product> medium =  products.stream().filter(product -> product.getPrice().compareTo(cheapLimit) > 0 && product.getPrice().compareTo(expensiveLimit) < 0).collect(Collectors.toList());
        List<Product> expensive =  products.stream().filter(product ->  product.getPrice().compareTo(expensiveLimit) > 0).collect(Collectors.toList());

        Map<PriceRange, List<Product>> priceRangeListMap= new HashMap<>();
        priceRangeListMap.put(PriceRange.CHEAP, cheap);
        priceRangeListMap.put(PriceRange.MEDIUM, medium);
        priceRangeListMap.put(PriceRange.EXPENSIVE, expensive);

//        return products.stream()...;

        return priceRangeListMap;

       // throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    public static void main(String[] args) {

        AdvancedStreamsExercise03 ase03 = new AdvancedStreamsExercise03();

        System.out.println(ase03.groupProductsByPriceRange(ExampleData.getProducts(), new BigDecimal("2.0"), new BigDecimal("5.0")));
    }
}
