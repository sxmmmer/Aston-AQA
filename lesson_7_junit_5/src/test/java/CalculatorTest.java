import org.junit.jupiter.api.Test;
import org.sxmmer.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testSum() {
        assertEquals(5, Calculator.sum(2,3));
    }

    @Test
    void testSubtract() {
        assertEquals(10, Calculator.subtract(30,20));
    }

    @Test
    void testMultiply() {
        assertEquals(25, Calculator.multiply(5,5));
    }

    @Test
    void testDivide() {
        assertEquals(3, Calculator.divide(12,4));
    }
}
