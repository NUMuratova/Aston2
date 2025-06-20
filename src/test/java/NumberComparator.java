public class NumberComparator {
    public static String compareNumbers(int num1, int num2) {
        if (num1 > num2)
            return "Первое число больше второго";
        else if (num1 < num2)
            return "Второе число больше первого";
        else
            return "Числа равны";
    }
}
