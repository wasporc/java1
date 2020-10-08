package rest.context;

import rest.state.State;

/**
 * Контроллер состояния.
 */
public class StateController extends State {

    State satietyState;

    /**
     * Задать новое состояние.
     * @param satietyState новое состояние.
     */
    public void setSatietyState(State satietyState) {
        this.satietyState = satietyState;
    }

    @Override
    public void isSatiety() {
        satietyState.isSatiety();
    }
}
