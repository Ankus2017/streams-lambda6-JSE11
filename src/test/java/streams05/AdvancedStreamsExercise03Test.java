package streams05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streams05.exercises.AdvancedStreamsExercise03;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import static streams05.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static streams05.exercises.AdvancedStreamsExercise03.PriceRange.*;

class AdvancedStreamsExercise03Test {

    private AdvancedStreamsExercise03 exercise = new AdvancedStreamsExercise03();

    @Test
    @DisplayName("Group products by price range")
    void groupProductsByPriceRange() {
        assertThat(exercise.groupProductsByPriceRange(TestData.getProducts(), new BigDecimal("3.00"), new BigDecimal("6.00")))
                .describedAs("Exercise 4: Your solution does not return the correct result.")
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        CHEAP, List.of(APPLES, SPAGHETTI),
                        MEDIUM, List.of(PENCILS, DETERGENT),
                        EXPENSIVE, List.of(PLATES, KNIVES, FORKS)));
    }
}
