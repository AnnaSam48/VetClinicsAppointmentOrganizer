package generators.strategies;

import models.TimeSlot;
import models.animals.Animal;

public class AppointmentStrategyForAnimalCreationContext {

    private AppointmentStrategy strategy;

    public AppointmentStrategyForAnimalCreationContext(AppointmentStrategy strategy){
        this.strategy = strategy;
    }

    public Animal animalAccordingToStrategy(TimeSlot appointmentTime){
        return strategy.getNewAppointmentAnimal(appointmentTime);
    }

    public void setStrategy(AppointmentStrategy strategy)
    {
        this.strategy = strategy;
    }

}
