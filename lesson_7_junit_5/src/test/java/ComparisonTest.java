import org.junit.jupiter.api.Test;
import org.sxmmer.Comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonTest {
    @Test
    void testGreater() {
        assertEquals("a > b", Comparison.comparison(5,2));
    }

    @Test
    void testLess() {
        assertEquals("a < b", Comparison.comparison(3,8));
    }

    @Test
    void testEqual() {
        assertEquals("a == b", Comparison.comparison(5,5));
    }
}
