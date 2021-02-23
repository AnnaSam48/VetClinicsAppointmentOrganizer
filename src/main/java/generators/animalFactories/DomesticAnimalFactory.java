package generators.animalFactories;

import models.animals.DomesticAnimal;
import models.appointments.Appointment;


public class DomesticAnimalFactory extends AnimalFactory {

    @Override
    public DomesticAnimal createAnimal(Appointment appointment) {
        return new DomesticAnimal();
    }
}
