package generators.strategies;

import generators.animalFactories.AnimalFactory;
import generators.animalFactories.WildAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

public class EmergencyAppointmentStrategy implements AppointmentStrategy {

    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {
        AnimalFactory factory = new WildAnimalFactory();
        return factory.createAnimal();
    }
}
