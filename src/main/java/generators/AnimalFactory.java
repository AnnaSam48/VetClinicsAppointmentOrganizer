package generators;

import models.Animal;

abstract public class AnimalFactory {

    public void getCreatedAnimal() {
        Animal animalCreated = createAnimal();
    }

    public abstract Animal createAnimal();
}
