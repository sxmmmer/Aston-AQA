import org.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TriangleAreaTest {
    @Test
    void testArea() {
        assertEquals(TriangleArea.triangleArea(10,5),25.0);
    }
}
