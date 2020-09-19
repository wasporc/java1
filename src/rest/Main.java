package rest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1: " + Arrays.toString(
                changeOneAndZero(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
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
}
