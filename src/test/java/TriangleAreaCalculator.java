public class TriangleAreaCalculator {
    // Площадь треугольника по формуле Герона
    public static double triangleArea(double a, double b, double c) {
        if (!isValidTriangle(a, b, c))
            throw new IllegalArgumentException("Недопустимые стороны треугольника");

        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }
}
