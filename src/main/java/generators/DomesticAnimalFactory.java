package generators;

import models.DomesticAnimal;


public class DomesticAnimalFactory extends AnimalFactory {

    @Override
    public DomesticAnimal createAnimal() {
        return new DomesticAnimal();
    }
}
