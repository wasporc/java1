package rest.state;

/**
 * Состояние когда немного покушал, но не наелся до предела.
 */
public class SatietyState extends State{
    @Override
    public void isSatiety() {
        System.out.println(" покушавший");
    }
}
