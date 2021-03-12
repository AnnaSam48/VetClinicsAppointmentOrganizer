package factories.animalFactories;

import models.animals.DomesticAnimal;


public class DomesticAnimalFactory extends AnimalFactory {

    @Override
    public DomesticAnimal createAnimal() {
        return new DomesticAnimal();
    }
}
