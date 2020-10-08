package rest;

import rest.context.StateController;
import rest.model.Bowl;
import rest.model.Cat;

import java.util.Random;

/**
 * Симулятор кормления котов.
 * Рандом вставлен для генерации разной вместительности котов и разной прожорливости.
 */
public class Main {

    public static void main(String[] args) {
        //задаем максимальный объем миски
        Bowl bowl = new Bowl(1000);
        //ген. рандома ну просто что бы по разному все выходило
        Random random = new Random();
        //заполняем миску
        bowl.doFillBowl(random.nextInt(1000));

        //делаем котов
        Cat[] cats = {
                new Cat("Пушок",0, random.nextInt(50)+50, new StateController()),
                new Cat("Федор",0, random.nextInt(50)+50, new StateController()),
                new Cat("Барсик",0, random.nextInt(50)+50, new StateController()),
                new Cat("Зассанец пушистый",0, random.nextInt(50)+50, new StateController()),
        };
        //кормим котов
        for (Cat cat : cats) {
            cat.eatFood(bowl, random.nextInt(150));
            cat.isSatiety();
        }
    }
}
