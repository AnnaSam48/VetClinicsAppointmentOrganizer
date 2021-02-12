package generators;

import models.WildAnimal;

public class WildAnimalFactory extends AnimalFactory {


    @Override
    public WildAnimal createAnimal() {
        return new WildAnimal();
    }
}
