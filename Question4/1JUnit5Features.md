
# JUnit 5 Core Features: Explanation and Implementation

This document explains four key features of the JUnit 5 testing framework—Test Execution Order, Parameterized Tests, Dynamic Tests, and Parallel Execution—and demonstrates each with code examples. JUnit 5 is a modern Java testing framework with a modular architecture, designed for flexibility and robustness. The accompanying file `JUnit5DemoTests.java` provides executable implementations of these features.

## 1. Test Execution Order
### Explanation
JUnit 5 allows controlling the order of test method execution within a class or across classes, unlike JUnit 4, where order was non-deterministic by default. This is useful for tests requiring a specific sequence (e.g., setup before validation). Test execution order can be customized at the method or class level using annotations like `@TestMethodOrder` and `@Order`.

- **Method-Level Order**: Use `@TestMethodOrder` with `MethodOrderer.OrderAnnotation.class` and annotate test methods with `@Order(n)` to specify their sequence.
- **Class-Level Order**: Use `@TestClassOrder` with `ClassOrderer.OrderAnnotation.class` and annotate test classes with `@Order(n)`.

### Example
The following code (from `JUnit5DemoTests.java`) demonstrates method-level execution order:
```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5DemoTests {
    @Test
    @Order(1)
    void firstTest() {
        Assertions.assertTrue(true, "First test executed");
    }

    @Test
    @Order(2)
    void secondTest() {
        Assertions.assertEquals(4, 2 + 2, "Second test executed");
    }
}
```
- **Explanation**: `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` enables ordered execution. `@Order(1)` ensures `firstTest` runs before `secondTest` (with `@Order(2)`).

## 2. Parameterized Tests
### Explanation
Parameterized tests allow running the same test method multiple times with different inputs, reducing code duplication. JUnit 5 uses `@ParameterizedTest` with data sources like `@ValueSource`, `@CsvSource`, or `@MethodSource` to provide inputs.

- **Key Annotations**:
  - `@ParameterizedTest`: Marks a test method as parameterized.
  - `@ValueSource`: Supplies a simple array of values (e.g., strings, integers).
  - `@CsvSource`: Provides data in CSV format for multiple parameters.

### Example
The following code tests if strings are non-null with different inputs:
```java
@ParameterizedTest
@ValueSource(strings = {"hello", "world", ""})
void testNonNullString(String input) {
    Assertions.assertNotNull(input, "Input should not be null");
}
```
- **Explanation**: The test runs three times, with `input` set to "hello", "world", and "". Each iteration checks if the input is non-null.

## 3. Dynamic Tests
### Explanation
Dynamic tests are generated at runtime using `@TestFactory`, which returns a collection of `DynamicTest` instances. This is useful for creating tests based on runtime conditions (e.g., testing files in a directory). Unlike static `@Test` methods, dynamic tests are defined programmatically.

### Example
The following code generates dynamic tests for even numbers:
```java
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
```
- **Explanation**: The `@TestFactory` method generates three tests for even numbers (2, 4, 6), each checking if the number is divisible by 2.

## 4. Parallel Execution
### Explanation
JUnit 5 supports parallel test execution to reduce runtime for large test suites. Parallel execution is configured via the `junit-platform.properties` file or system properties, with options for class-level or method-level parallelism.

- **Configuration**:
  - Enable parallelism: `junit.jupiter.execution.parallel.enabled=true`
  - Set mode: `junit.jupiter.execution.parallel.mode.default=concurrent` (for methods) or `same_thread` (sequential).
  - Set thread pool size: `junit.jupiter.execution.parallel.config.fixed.parallelism=4`.

### Example
Configure parallel execution in `junit-platform.properties`:
```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
junit.jupiter.execution.parallel.config.fixed.parallelism=2
```
Test example:
```java
@Test
void parallelTest1() {
    Assertions.assertTrue(true, "Parallel test 1");
}

@Test
void parallelTest2() {
    Assertions.assertTrue(true, "Parallel test 2");
}
```
- **Explanation**: With the above configuration, `parallelTest1` and `parallelTest2` may run simultaneously on separate threads, reducing total execution time.

## Implementation Notes
The full implementation is in `JUnit5DemoTests.java`, which includes all examples above. To run the tests:
1. Ensure JUnit 5 dependencies are added (e.g., via Maven):
   ```xml
   <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter</artifactId>
       <version>5.10.0</version>
       <scope>test</scope>
   </dependency>
   ```
2. Place `junit-platform.properties` in the project root or `Question4/`.
3. Compile and run tests using Maven (`mvn test`) or an IDE like VS Code.

## Conclusion
JUnit 5’s features enhance testing flexibility:
- **Test Execution Order**: Ensures predictable test sequences using `@Order`.
- **Parameterized Tests**: Reduces code duplication with `@ParameterizedTest`.
- **Dynamic Tests**: Enables runtime test generation with `@TestFactory`.
- **Parallel Execution**: Speeds up test suites with configurable parallelism.
These features make JUnit 5 versatile for academic and industry projects, as demonstrated in `JUnit5DemoTests.java`.



