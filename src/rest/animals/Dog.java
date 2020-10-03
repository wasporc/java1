package rest.animals;

public class Dog extends Animals{
    public static final String SHEPARD = "shepard";
    public static final String BULLDOG = "bulldog";
    public static final String POODLE = "poodle";

    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean swimming(int distance) {
        return distance <= 10;
    }

    @Override
    public boolean jumping(double height) {
        return height <= 0.5d;
    }

    /**
     * такой синтаксис return и switch вижу первый раз,
     * но если ИДЕА и компилятор не ругаются, то ладно.
     */
    @Override
    public boolean running(int distance) {
        return switch (breed) {
            case SHEPARD -> distance <= 700;
            case BULLDOG -> distance <= 200;
            case POODLE -> distance <= 400;
            default -> distance <= 500;
        };
    }

    @Override
    public String toString() {
        return "Dog " + breed;

    }
}
