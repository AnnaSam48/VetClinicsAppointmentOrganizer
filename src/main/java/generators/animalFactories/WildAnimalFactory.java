package generators.animalFactories;

import models.animals.WildAnimal;
import models.appointments.Appointment;

public class WildAnimalFactory extends AnimalFactory {


    @Override
    public WildAnimal createAnimal() {
        return new WildAnimal();
    }
}
