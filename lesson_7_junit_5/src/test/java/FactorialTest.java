import org.sxmmer.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(120, Factorial.factorial(5));
    }
}
