package rest.animals;

public class Cat extends Animals{
    /**
     *  вообще коты умеют плавать
     */
    @Override
    public boolean swimming(int distance) {
        return false;
    }

    @Override
    public boolean jumping(double height) {
        return height <= 2;
    }

    @Override
    public boolean running(int distance) {
        return distance <= 200;
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
