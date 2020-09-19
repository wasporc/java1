package rest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.print("Задание 1: \n[ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ] -> ");
        System.out.println(
                Arrays.toString(changeOneAndZero(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println("Задание 2: ");
        fillArray();
        System.out.println();
        System.out.println("Задание 3: ");
        tusk3();
        System.out.println();
        System.out.println("Задание 4: ");
        squareArray();
        System.out.println();
        System.out.println("Задание 5: ");
        minMax();
        System.out.println();
        System.out.println("Задание 6: ");
        System.out.println(checkBalance(new int[]{2, 2, 3, 1, 2, 2, 10, 1, 1}));
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * @param array целочисленный массив.
     */
    static int[] changeOneAndZero(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    /**
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    static void fillArray(){
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(array[i] + " ");
        }
    }

    /**
     *  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     *  пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    static void tusk3(){
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number < 6) array[i] = number * 2;
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    static void squareArray(){
        int[][] square = new int[5][5];
        int step = 0;
        for (int i = 0; i < square.length; i++) {
            if (i%2 != 0) step = -1;
            for (int j = 0; j < square[i].length; j++) {
                if (step%2 == 0) square[i][j] = 1;
                System.out.print(square[i][j] + " ");
                step++;
            }
            step = 0;
            System.out.println();
        }
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    static void minMax(){
        int[] array = new int[10];
        System.out.print("В массиве [");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
            System.out.print(array[i]+" ");
        }
        System.out.print("] \n");
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println("Максимально значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    static boolean checkBalance(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum%2 != 0) return false;
        int findSum = sum/2;
        int mark = 0;
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            mark += array[i];
            System.out.print(array[i] + " ");
            if (mark == findSum){
                System.out.print("|| ");
            }
        }
        System.out.print("]");
        return true;
    }
}
