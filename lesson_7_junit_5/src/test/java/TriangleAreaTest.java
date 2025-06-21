import org.junit.jupiter.api.Test;
import org.sxmmer.TriangleArea;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class TriangleAreaTest {
     @Test
     void testArea() {
         assertEquals(6.0,TriangleArea.triangleArea(3,4));
     }
}
