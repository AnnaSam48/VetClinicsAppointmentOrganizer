package generators.animalFactories;

import models.animals.WildAnimal;
import models.appointments.Appointment;

public class WildAnimalFactory extends AnimalFactory {


    @Override
    public WildAnimal createAnimal(Appointment appointment) {
        if(appointment.getClass().isInstance())
        return new WildAnimal();
    }
}