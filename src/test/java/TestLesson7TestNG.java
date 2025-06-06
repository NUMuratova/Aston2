import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestLesson7TestNG {

    @DataProvider(name="factorials")
    public Object[][] factorials() {
        return new Object[][]{
                {5, 120},
                {0, 1},
                {-1, null}
        };
    }

    @Test(dataProvider = "factorials")
    public void testFactorial(int input, Long expectedResult) {
        try {
            Assert.assertEquals(FactorialCalculator.factorial(input), expectedResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @DataProvider(name="triangles")
    public Object[][] triangles() {
        return new Object[][]{
                {3.0, 4.0, 5.0, 6.0},
                {1.0, 1.0, 3.0, Double.NaN},
        };
    }

    @Test(dataProvider = "triangles")
    public void testTriangleArea(double sideA, double sideB, double sideC, Double expectedArea) {
        try {
            Assert.assertEquals(TriangleAreaCalculator.triangleArea(sideA, sideB, sideC),
                    expectedArea.doubleValue(), 0.001d);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    @DataProvider(name="arithmetic")
    public Object[][] arithmetic() {
        return new Object[][]{
                {"add", 7, 8, 15},
                {"subtract", 10, 3, 7},
                {"multiply", 5, 6, 30},
                {"divide", 10, 2, 5},
                {"divide", 10, 0, Integer.MIN_VALUE}
        };
    }

    @Test(dataProvider = "arithmetic")
    public void testArithmetic(String operation, int firstNum, int secondNum, int expectedResult) {
        switch(operation) {
            case "add":
                Assert.assertEquals(ArithmeticOperations.add(firstNum, secondNum), expectedResult);
                break;
            case "subtract":
                Assert.assertEquals(ArithmeticOperations.subtract(firstNum, secondNum), expectedResult);
                break;
            case "multiply":
                Assert.assertEquals(ArithmeticOperations.multiply(firstNum, secondNum), expectedResult);
                break;
            case "divide":
                try {
                    Assert.assertEquals(ArithmeticOperations.divide(firstNum, secondNum), expectedResult);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage()); // Сообщаем об ошибке
                }
                break;
            default:
                Assert.fail("Неподдерживаемая операция: " + operation);
        }
    }

    @DataProvider(name="comparisons")
    public Object[][] comparisons() {
        return new Object[][]{
                {5, 3, "Первое число больше второго"},
                {2, 8, "Второе число больше первого"},
                {4, 4, "Числа равны"}
        };
    }

    @Test(dataProvider = "comparisons")
    public void testCompareNumbers(int firstNum, int secondNum, String expectedComparison) {
        Assert.assertEquals(NumberComparator.compareNumbers(firstNum, secondNum), expectedComparison);
    }
}