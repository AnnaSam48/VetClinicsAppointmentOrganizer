package factories.animalFactories;

import models.animals.WildAnimal;

public class WildAnimalFactory extends AnimalFactory {


    @Override
    public WildAnimal createAnimal() {
        return new WildAnimal();
    }
}
