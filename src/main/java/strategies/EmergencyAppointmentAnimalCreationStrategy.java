package strategies;

import factories.animalFactories.AnimalFactory;
import factories.animalFactories.WildAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

public class EmergencyAppointmentAnimalCreationStrategy implements AppointmentAnimalCreationStrategy {

    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {
        AnimalFactory factory = new WildAnimalFactory();
        return factory.createAnimal();
    }
}
