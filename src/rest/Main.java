package rest;

public class Main {


    public static void main(String[] args) {
        int aInt = 0;
        float aFloat = 0f;
        double aDouble = 0;
        byte aByte = 0;
        short aShort = 0;
        long aLong = 0;
        boolean aBoolean = true;
        char aChar = 'a';
        System.out.println("Задание 3 : " + quest3(2, 4, 6, 8));
        System.out.println("Задание 4 : " + quest4(6, 6));
        System.out.print("Задание 5 : ");
        quest5(5);
        System.out.println("Задание 6 : " + quest6(5));
        System.out.print("Задание 7 : ");
        quest7("Billi");
        int year = 2020;
        System.out.print("Задание 8 : " + year + " ");
        quest8(year);
    }


    /**
     * Написать метод вычисляющий выражение a * (b + (c / d))
     * и возвращающий результат,где a, b, c, d – входные параметры этого метода;
     */
    public static int quest3(int a, int b, int c, int d) {
        if (d == 0) return 0;
        return a * (b + (c / d));
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
     * от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    public static boolean quest4(int a, int b) {
        int sum = a + b;
        return  (10 <= sum && sum <= 20);
    }

    /**
     *  Написать метод, которому в качестве параметра передается целое число,
     *  метод должен напечатать в консоль положительное ли число передали, или отрицательное;
     *  Замечание: ноль считаем положительным числом.
     */
    public static void quest5(int a){
        System.out.println(a >= 0 ? "Положительно" : "Отрицательно");
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен вернуть true, если число отрицательное;
     */
    public static boolean quest6(int a){
        return a < 0;
    }

    /**
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void quest7(String name){
        System.out.println("Привет, " + name);
    }


    /**
     * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     * @param year год.
     */
    public static void quest8(int year){
        System.out.println(
                (year%4 == 0)^(year%100 == 0)^(year%400 == 0) ? "Год високосный" : "Год не високосный");
    }



}
