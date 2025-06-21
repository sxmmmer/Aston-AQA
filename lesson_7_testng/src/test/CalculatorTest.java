import org.Calculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @Test
    void testSum() {
        assertEquals(Calculator.sum(2,3),5);
    }

    @Test
    void testSubtract() {
        assertEquals(Calculator.subtract(10,4),6);
    }

    @Test
    void testMultiply() {
        assertEquals(Calculator.multiply(3,3), 9);
    }

    @Test
    void testDivide() {
        assertEquals(Calculator.divide(12,4),3);
    }
}
