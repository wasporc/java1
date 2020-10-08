package rest.model;

import rest.context.StateController;
import rest.state.HungerState;
import rest.state.OversaturationState;
import rest.state.SatietyState;

/**
 * Кот.
 * т.к. мы имеет дело только с котами, то и никакие абстрактные классы типа Animal нам не нужны.
 * у котов тоже есть количество влезаемой в них еды (хотя в этом я не уверен).
 * Состояние кота будет сообщаться не в boolean, но все будет понятно.(состояний будет больше чем 2)
 */
public class Cat {
    //кошачий пище бак
    private int foodTank;
    //имя кота
    private final String name;
    //максимальный размер пище бака ( коты бывают разные и жрут они по разному много )
    private final int foodTankSize;
    //собственно сам контроллер кошачего состояния
    private final StateController satietyState;

    public Cat(String name, int foodTank, int foodTankSize, StateController satietyState) {
        this.name = name;
        this.foodTank = foodTank;
        this.foodTankSize = foodTankSize;
        this.satietyState = satietyState;
        changeState();
    }

    public String getName() {
        return name;
    }

    /**
     * Метод поедания пищи.
     * @param bowl миска с едой.
     * @param take количество съеденной пищи.
     */
    public void eatFood(Bowl bowl, int take){
        if (foodTank <= foodTankSize){
            foodTank += bowl.getFood(take);
            changeState();
        }
    }

    /**
     * Показать состояние.
     */
    public void isSatiety(){
        System.out.print(getName());
        satietyState.isSatiety();
    }

    /**
     * Сменить состояние.
     */
    private void changeState(){
        if (foodTank >= foodTankSize/2 && foodTank < foodTankSize){
            satietyState.setSatietyState(new SatietyState());
        }else if (foodTank < foodTankSize/2){
            satietyState.setSatietyState(new HungerState());
        }else {
            satietyState.setSatietyState(new OversaturationState());
        }
    }
}
