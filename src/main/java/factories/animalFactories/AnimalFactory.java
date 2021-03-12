package factories.animalFactories;

import models.animals.Animal;

abstract public class AnimalFactory {

    boolean isWild;
    String animal;

    public abstract Animal createAnimal();
}
