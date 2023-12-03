package streams04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streams04.exercises.BasicStreamsExercise01;

import static streams04.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class BasicStreamsExercise01Test {

    private BasicStreamsExercise01 exercise = new BasicStreamsExercise01();

    @Test
    @DisplayName("Find utensils sorted by name")
    void findUtensilsSortedByName() {
        assertThat(exercise.findUtensilsSortedByName(TestData.getProducts()))
                .describedAs("Exercise 1: Your solution does not return utensils sorted by name.")
                .containsExactly(FORKS, KNIVES, PLATES);
    }
}
