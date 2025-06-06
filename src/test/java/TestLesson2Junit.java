import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLesson2Junit {

    @Test
    void testFactorial() {
        assertEquals(FactorialCalculator.factorial(5), 120); 
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.factorial(-1)); 
    }

    @Test
    void testTriangleArea() {
        assertEquals(TriangleAreaCalculator.triangleArea(3, 4, 5), 6.0, 0.001); 
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.triangleArea(1, 1, 3)); 
    }

    @Test
    void testArithmeticOperations() {
        assertEquals(ArithmeticOperations.add(7, 8), 15);
        assertEquals(ArithmeticOperations.subtract(10, 3), 7);
        assertEquals(ArithmeticOperations.multiply(5, 6), 30);
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0));
    }

    @Test
    void testCompareNumbers() {
        assertEquals(NumberComparator.compareNumbers(5, 3), "Первое число больше второго");
        assertEquals(NumberComparator.compareNumbers(2, 8), "Второе число больше первого");
        assertEquals(NumberComparator.compareNumbers(4, 4), "Числа равны");
    }
}
