package strategies;

import factories.animalFactories.AnimalFactory;
import factories.animalFactories.DomesticAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

public class NonEmergencyAppointmentAnimalCreationStrategy implements AppointmentAnimalCreationStrategy {
    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {
        AnimalFactory factory = new DomesticAnimalFactory();
        return factory.createAnimal();
    }
}
