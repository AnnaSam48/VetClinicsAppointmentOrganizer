package factories.animalFactories;

import models.animals.WildAnimal;


public class WildAnimalFactory extends AnimalFactory {


    @Override
    public WildAnimal createAnimal(boolean isWildAnimal, String animal) {
        return new WildAnimal(isWildAnimal, animal);
    }
}
