import org.Comparison;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ComparisonTest {
    @Test
    void testGreater() {
        assertEquals(Comparison.comparison(5,2), "a > b");
    }

    @Test
    void testLess() {
        assertEquals(Comparison.comparison(1,9), "a < b");
    }

    @Test
    void testEqual() {
        assertEquals(Comparison.comparison(7,7), "a == b");
    }
}
