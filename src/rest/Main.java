package rest;

import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * Программа 2 в 1. Спрашивает в какую игру будем играть. 1 - угадывание чисел и 2 - угадывание слов.
     * Если надо разделить на две отдельные программы (проекта или класса) сообщите, разделю.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("В какую игру поиграем сегодня?\n1 - угадываем число\n2 - угадываем слово");
        int chose = scanner.nextInt();
        switch (chose) {
            case 1 -> playingWithNumbers(scanner, random);
            case 2 -> playingWithSimpleWord(scanner, random);
            default -> System.out.println("Что то вы не то выбрали! Пока.");
        }
        scanner.close();
    }

    /**
     * Игра в угадывание слов. Словом exit можно выйти , а так она будет спрашивать пока не угадаете.
     * @param scanner сканер для считывания ответа пользователя
     * @param random генератор случайных чисел
     */
    private static void playingWithSimpleWord(Scanner scanner, Random random) {
        String[] words = createWordsArray();
        String winWord = words[random.nextInt(words.length)];
        String buff;
        System.out.println("Попробуйте угадать :");
        do{
            String userWord = scanner.next();
            if (userWord.equals("exit")){
                System.out.println("Отлично! Вы проиграли!!");
                break;
            }
            String correctsChars = "";
            buff = "################################";
            if (userWord.length() > winWord.length())
                userWord = userWord.substring(0,winWord.length());
            for (int j = 0; j < userWord.length(); j++) {
                char c = userWord.charAt(j);
                if (!winWord.startsWith(String.valueOf(userWord.charAt(0))))
                    break;
                int index = winWord.substring(j).indexOf(userWord.charAt(j));
                if ( index != -1)
                    correctsChars += c;
                else
                    correctsChars += "#";
                buff = correctsChars + buff.substring(j);
            }
            if (userWord.equals(winWord)) {
                System.out.println("Все верно! Слово " + winWord);
                break;
            }
            System.out.println(choseAnswerText(random.nextInt(5)));
            System.out.println("Подсказка: " + buff.substring(0,15));
        }
        while (true);
    }

    /**
     * Игра в угадывание чисел от 0 до 9.
     * @param scanner сканер для считывания ответа пользователя
     * @param random генератор случайных чисел
     */
    public static void playingWithNumbers(Scanner scanner, Random random) {
        int count = 0;
        int chose;
        do {
            System.out.println("Отлично! Угадываем число от 0 до 9");
            int winNumber = random.nextInt(10);
            while (true) {
                int userNumber = scanner.nextInt();
                if (userNumber == winNumber) {
                    System.out.println("Победа! Еще сыграем? 1 – да / 0 – нет :");
                    chose = scanner.nextInt();
                    if (chose == 1) count = 0;
                    break;
                }
                count++;
                if (count == 3) {
                    System.out.println("Загаданное число " + winNumber +
                            ". Больше попыток нет.\nЕще сыграем? 1 – да / 0 – нет :");
                    chose = scanner.nextInt();
                    if (chose == 1) count = 0;
                    break;
                }
                System.out.println("Попытка " + count);
                if (userNumber > winNumber) {
                    System.out.println("Загаданное число меньше " + userNumber);
                } else {
                    System.out.println("Загаданное число больше " + userNumber);
                }
            }
        } while (count == 0);
    }

    /**
     * Метод возвращает разные комментарии на неудачи в угадывании слов (сделал просто так)
     * @param index индекс комментария в массиве
     * @return комментарии
     */
    private static String choseAnswerText(int index) {
        String[] answer = {"Не победа, но хорошая попытка.", "Уже ближе, но нет.", "Попробуйте еще раз.",
                "Только не говорите, что сдаетесь...", "Времени у меня много, пробуйте."};
        return answer[index];
    }

    /**
     * Создает массив слов.
     * @return массив
     */
    private static String[] createWordsArray() {
        return new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
    }

}
