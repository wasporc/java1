package rest;

import rest.animals.Animals;
import rest.animals.Cat;
import rest.animals.Dog;

public class Main {

    public static void main(String[] args) {
        Animals[] animals = {
          new Cat(),
          new Dog(Dog.SHEPARD),
          new Dog(Dog.BULLDOG),
          new Dog(Dog.POODLE)
        };

        for (Animals animal : animals) {
            System.out.println("===============================");
            System.out.println(animal + " jump : " + animal.jumping(2 ));
            System.out.println(animal + " run : " + animal.running(200 ));
            System.out.println(animal + " swim : " + animal.swimming(10 ));
        }

    }
}
