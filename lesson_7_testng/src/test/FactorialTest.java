import org.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(Factorial.factorial(5), 120);
    }
}
