public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");

        return calculateFactorial(n);
    }

    private static long calculateFactorial(int n) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
