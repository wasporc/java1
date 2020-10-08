package rest.state;

/**
 * Состояние голодного.
 */
public class HungerState extends State {
    @Override
    public void isSatiety() {
        System.out.println(" голодный");
    }
}
