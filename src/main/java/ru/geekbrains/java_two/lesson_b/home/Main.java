package main.java.ru.geekbrains.java_two.lesson_b.home;

public class Main {
    public static void main(String[] args) {
        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] matrix;

        try {
            matrix = getArrayFromString(string);
            printArray(matrix);
        } catch (IllegalArraySizeException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("После работы с матрицей было получено число: " + workWithArray(matrix));
        } catch (StringToIntCastException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getArrayFromString(String str) {
        String[] array = str.replaceAll("\n", " ").split(" ");

        if (array.length / Math.sqrt(array.length) != 4.0) throw new IllegalArraySizeException("Bad array size"); // Выкидываем исключение, если в матрице число строк и столбцов не будет равно 4

        String[][] matrix = new String[4][4];
        int arrayIterator = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = array[arrayIterator];
                arrayIterator++;
            }
        }
        return matrix;
    }

    private static int workWithArray(String[][] matrix) {
        int sum = 0;

        for (String[] string : matrix) {
            for (String element : string) {
                if (!element.matches("[-+]?\\d+")) throw new StringToIntCastException("Bad symbol found"); //Если элемент в массиве не является числом, выкидываем исключение
                sum += Integer.parseInt(element);
            }
        }
        return sum / 2;
    }

    // Метод для распечатки массива
    private static void printArray(String[][] doubleArray) {
        for (String[] str : doubleArray) {
            for (String element : str) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
