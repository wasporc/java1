package rest.state;

/**
 * Состояние объелся по полной.
 */
public class OversaturationState extends State {
    @Override
    public void isSatiety() {
        System.out.println(" переевший");
    }
}
