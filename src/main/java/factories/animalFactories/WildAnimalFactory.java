package factories.animalFactories;

import models.animals.WildAnimal;


public class WildAnimalFactory implements AnimalFactory {


    @Override
    public WildAnimal createAnimal(boolean isWildAnimal, String animal) {
        return new WildAnimal(isWildAnimal, animal);
    }
}
