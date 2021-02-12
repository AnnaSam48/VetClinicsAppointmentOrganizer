package generators.animalFactories;

import models.animals.Animal;

abstract public class AnimalFactory {

    public void getCreatedAnimal() {
        Animal animalCreated = createAnimal();
    }

    public abstract Animal createAnimal();
}
