package generators.strategies;

import generators.animalFactories.AnimalFactory;
import generators.animalFactories.DomesticAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

public class NonEmergencyAppointmentStrategy implements AppointmentStrategy {
    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {
        AnimalFactory factory = new DomesticAnimalFactory();
        return factory.createAnimal();
    }
}
