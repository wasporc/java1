package rest.model;

/**
 * Миска
 */
public class Bowl {
    //Наполненность миски едой
    private int fullness;
    //Максимальный объем миски
    private final int maxVolume;

    public Bowl(int maxVolume) {
        this.maxVolume = maxVolume;
        this.fullness = 0;
        System.out.println("Миска на " + maxVolume + " вкусняшек.");
    }

    /**
     * Метод отдает еду из миски.
     * @param take количество , сколько возьмут.
     * @return возвращает тот же take.
     */
    public int getFood(int take) {
        if (this.fullness - take < 0){
            System.out.println("В миске нет столько еды.");
            return 0;
        }
        this.fullness -= take;
        System.out.println("В миске осталось " + this.fullness + " вкусняшек.");
        return take;
    }

    /**
     * Метод наполняет миску едой.
     * @param fullness количество насыпаемой еды.
     */
    public void doFillBowl(int fullness) {
        this.fullness += fullness;
        if(this.fullness >= maxVolume) {
            int drop = this.fullness - maxVolume;
            this.fullness = maxVolume;
            System.out.println("Миска полная, хватит сыпать.");
            System.out.println("Просыпалось " + drop + " вкусняшек.");
        }else
            System.out.println("В миске " + this.fullness + " вкусняшек.");
    }
}
