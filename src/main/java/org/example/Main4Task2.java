import java.awt.Color;

    interface Shape {
        double calculatePerimeter();
        double calculateArea();
        Color getFillColor();
        Color getBorderColor();

        default void printShapeInfo() {
            System.out.printf(
                    "%s:\n\tПериметр: %.2f\n\tПлощадь: %.2f\n\tЦвет заливки: %s\n\tЦвет границы: %s%n",
                    this.getClass().getSimpleName(),
                    calculatePerimeter(),
                    calculateArea(),
                    getFillColor(),
                    getBorderColor()
            );
        }
    }

    class Rectangle implements Shape {
        private final double width;
        private final double height;
        private final Color fillColor;
        private final Color borderColor;

        public Rectangle(double width, double height, Color fillColor, Color borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }
    }

    class Circle implements Shape {
        private final double radius;
        private final Color fillColor;
        private final Color borderColor;

        public Circle(double radius, Color fillColor, Color borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }
    }

    class Triangle implements Shape {
        private final double sideA;
        private final double sideB;
        private final double sideC;
        private final Color fillColor;
        private final Color borderColor;

        public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double calculateArea() {
            double semiPerimeter = calculatePerimeter() / 2;
            return Math.sqrt(semiPerimeter *
                    (semiPerimeter - sideA) *
                    (semiPerimeter - sideB) *
                    (semiPerimeter - sideC)); // Формула Герона
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }
    }

    // Основной класс программы
    public class Main4Task2 {
        public static void main(String[] args) {
            Shape rectangle = new Rectangle(4, 5, Color.BLUE, Color.RED);
            Shape circle = new Circle(3, Color.GREEN, Color.BLACK);
            Shape triangle = new Triangle(3, 4, 5, Color.YELLOW, Color.PINK);

            rectangle.printShapeInfo();
            circle.printShapeInfo();
            triangle.printShapeInfo();
        }
    }
