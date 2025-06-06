import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLesson2Junit {

    @Test
    void testFactorial() {
        assertEquals(FactorialCalculator.factorial(5), 120); // Проверка правильного значения факториала
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.factorial(-1)); // Ошибка для отрицательных значений
    }

    @Test
    void testTriangleArea() {
        assertEquals(TriangleAreaCalculator.triangleArea(3, 4, 5), 6.0, 0.001); // Площади прямоугольного треугольника
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.triangleArea(1, 1, 3)); // Неверная сторона
    }

    @Test
    void testArithmeticOperations() {
        assertEquals(ArithmeticOperations.add(7, 8), 15);           // Правильное сложение
        assertEquals(ArithmeticOperations.subtract(10, 3), 7);      // Правильное вычитание
        assertEquals(ArithmeticOperations.multiply(5, 6), 30);       // Правильное умножение
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0));     // Деление на ноль должно вызывать исключение
    }

    @Test
    void testCompareNumbers() {
        assertEquals(NumberComparator.compareNumbers(5, 3), "Первое число больше второго");   // Первое больше
        assertEquals(NumberComparator.compareNumbers(2, 8), "Второе число больше первого");   // Второе больше
        assertEquals(NumberComparator.compareNumbers(4, 4), "Числа равны");                   // Числа равны
    }
}