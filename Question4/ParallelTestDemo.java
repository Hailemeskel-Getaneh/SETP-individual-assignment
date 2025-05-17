```java
package Question4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ParallelTestDemo {

    @Test
    void parallelTest1() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(true, "Parallel test 1");
    }

    @Test
    void parallelTest2() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(true, "Parallel test 2");
    }
}