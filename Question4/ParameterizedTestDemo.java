package Question4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", ""})
    void testNonNullString(String input) {
        Assertions.assertNotNull(input, "Input should not be null");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testPositiveInteger(int number) {
        Assertions.assertTrue(number > 0, number + " should be positive");
    }
}