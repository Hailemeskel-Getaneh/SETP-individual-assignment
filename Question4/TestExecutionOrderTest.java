package Question4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class TestExecutionOrderTest {

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

    @Test
    @Order(3)
    void thirdTest() {
        Assertions.assertNotNull("JUnit 5", "Third test executed");
    }
}