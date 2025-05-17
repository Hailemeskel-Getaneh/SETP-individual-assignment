```java
package Question4;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicTestDemo {

    @TestFactory
    Collection<DynamicTest> dynamicTests() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int number = i * 2;
            tests.add(DynamicTest.dynamicTest("Test even number " + number,
                () -> Assertions.assertTrue(number % 2 == 0, number + " should be even")));
        }
        return tests;
    }
}