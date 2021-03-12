package strategies;

import models.TimeSlot;
import models.animals.Animal;

public class AppointmentStrategyForAnimalCreationContext {

    private final AppointmentAnimalCreationStrategy strategy;

    public AppointmentStrategyForAnimalCreationContext(AppointmentAnimalCreationStrategy strategy){
        this.strategy = strategy;
    }

    public Animal animalAccordingToStrategy(TimeSlot appointmentTime){
        return strategy.getNewAppointmentAnimal(appointmentTime);
    }
}
