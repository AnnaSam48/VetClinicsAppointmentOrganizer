package factories.animalFactories;

import models.animals.Animal;

public interface AnimalFactory {

    public abstract Animal createAnimal(boolean isWild, String animal);
}
