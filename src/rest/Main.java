package rest;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final char PLAYER_MARK = 'X';
    private static final char AI_MARK = 'O';
    private static final char EMPTY_MARK = '-';
    private static final String BORDER = "========================";

    /**
     * main метод получился огромным, но как его уменьшить не могу придумать.
     * Программу писал с 0 не заглядывая в урок, но конечно, что в памяти отложилось с вебинара нашло отражение в коде.
     * Что тут творится:
     *      - Игрок задает размер поля
     *      - Создается карта и рандом решает кто будет ходить первым (я подумал что не честно что Игрок всегда первый)
     *      - Начинается игра до тех пор пока кто то не победит или ходы закончатся
     *      - ИИ очень коварен, он блокирует победу игроку и не упустит возможность победить сам
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playerWin = false;
        boolean AIWin = false;

        System.out.println("Выберите размер поля:");
        int mapSize = scanner.nextInt();
        //создание поля
        char[][] map = getMap(mapSize);
        //количество ходов в зависимости от поля
        int count = map.length * map.length;
        paintMap(map);
        //подкидывание монетки , кто ходит первый
        int firstMove = random.nextInt(2);
        do {
            switch (firstMove) {
                case 0 -> {//ходит игрок
                    playerMove(scanner, map);
                    playerWin = winFinder(map, PLAYER_MARK);
                    if (playerWin) {
                        System.out.println("Игрок победил");
                        paintMap(map);
                    }
                    firstMove = 1;
                }
                case 1 -> {//ходит ии
                    AIMove(random, map, count);
                    AIWin = winFinder(map, AI_MARK);
                    if (AIWin) {
                        System.out.println("AI победил");
                        paintMap(map);
                    }
                    firstMove = 0;
                }
            }
            if (AIWin || playerWin) {
                break;
            }
            System.out.println(BORDER);
            paintMap(map);
            count--;
            if (count == 0) {//ходы закончились
                System.out.println("Победила дружба");
                break;
            }
        } while (true);
    }

    /**
     * Ход игрока
     */
    private static void playerMove(Scanner scanner, char[][] map) {
        int x;
        int y;
        do {
            System.out.println(String.format("ВВедите Х-координату от 1 до %d", map.length));
            x = scanner.nextInt() - 1;
            System.out.println(String.format("ВВедите Y-координату  от 1 до %d", map.length));
            y = scanner.nextInt() - 1;
        } while (x < 0 || x > map.length-1 || y > map.length-1 || y < 0);
        if (map[x][y] != EMPTY_MARK) {
            System.out.println("Точка занята.");
            playerMove(scanner, map);
        }
        map[x][y] = 'X';
    }

    /**
     * Ход AI
     */
    private static void AIMove(Random random, char[][] map, int count) {
        if (count != 0)
            while (true) {
                int x;
                int y;
                char[][] testMap = getMap(map.length);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map.length; j++) {
                        testMap[i][j] = map[i][j];
                    }
                }
                boolean blockMove = testingWinMove(testMap, map);
                if (!blockMove) {
                    x = random.nextInt(map.length);
                    y = random.nextInt(map.length);
                    if (map[x][y] == EMPTY_MARK) {
                        map[x][y] = AI_MARK;
                        break;
                    }
                } else break;
            }
    }

    /**
     * AI смотрит как игрок или он сам может победить
     */
    private static boolean testingWinMove(char[][] testMap, char[][] map) {
        boolean blockMove = false;
        for (int i = 0; i < testMap.length; i++) {
            for (int j = 0; j < testMap.length; j++) {
                if (testMap[i][j] == EMPTY_MARK) {
                    testMap[i][j] = PLAYER_MARK;
                    if (winFinder(testMap, PLAYER_MARK)) {
                        map[i][j] = AI_MARK;
                        blockMove = true;
                        break;
                    } else {
                        testMap[i][j] = AI_MARK;
                        if (winFinder(testMap, AI_MARK)) {
                            map[i][j] = AI_MARK;
                            blockMove = true;
                            break;
                        } else {
                            testMap[i][j] = EMPTY_MARK;
                        }
                    }
                }
            }
            if (blockMove) break;
        }
        return blockMove;
    }

    /**
     * Проверка победы игрока или ИИ
     */
    private static boolean winFinder(char[][] map, char mark) {
        boolean[] check = new boolean[map.length];
        /**
         * проверка на диагональ с 1.1 до N.N
         */
        for (int i = 0; i < map.length; i++) {
            check[i] = map[i][i] == mark;
        }
        boolean winBoolean = checking(check);
        if (winBoolean) return true;
        /**
         * проверка на диагональ с 1.N до N.1
         */
        for (int i = 0; i < map.length; i++) {
            check[i] = map[i][map.length - 1 - i] == mark;
        }
        winBoolean = checking(check);
        if (winBoolean) return true;
        /**
         * проверка на прямую по Х
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                check[j] = map[i][j] == mark;
            }
            winBoolean = checking(check);
            if (winBoolean) return true;
        }
        /**
         * проверка на прямую по Y
         */
        for (int i = 0; i < map.length; i++) {
            winBoolean = yChecking(map, i, check, mark);
            if (winBoolean) return true;
        }

        return false;
    }

    /**
     * Вычисление массива победы
     */
    private static boolean checking(boolean[] check) {
        boolean x = check[0];
        for (int i = 0; i < check.length; i++) {
            x = x & check[i];
        }
        return x;
    }

    /**
     * Метод для заполнения массива вычисления победы
     */
    private static boolean yChecking(char[][] map, int j, boolean[] check, char mark) {
        for (int i = 0; i < map.length; i++) {
            check[i] = map[i][j] == mark;
        }
        return checking(check);
    }

    /**
     * Создание карты
     */
    private static char[][] getMap(int mapSize) {
        char[][] map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = EMPTY_MARK;
            }
        }
        return map;
    }

    /**
     * Отрисовка карты
     */
    private static void paintMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
