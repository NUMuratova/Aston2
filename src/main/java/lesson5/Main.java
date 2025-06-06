package lesson5;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "$", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };

        try {
            System.out.println("Сумма элементов массива равна: " + sumArray(array));
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        String[] arr = new String[3];
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Выход за пределы массива");
        }
    }

    private static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4)
            throw new MyArraySizeException();

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }
}

class MyArraySizeException extends Exception {}

class MyArrayDataException extends Exception {
    final int row;
    final int column;

    MyArrayDataException(int row, int col) {
        super("Некорректные данные в ячейке [" + row + ", " + col + "]");
        this.row = row;
        this.column = col;
    }
}
