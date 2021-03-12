package factories.animalFactories;

import models.animals.DomesticAnimal;


public class DomesticAnimalFactory implements AnimalFactory {

    @Override
    public DomesticAnimal createAnimal(boolean isWild, String animal) {
        return new DomesticAnimal(isWild,animal);
    }


}
