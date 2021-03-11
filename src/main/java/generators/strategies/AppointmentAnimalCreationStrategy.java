package generators.strategies;


import models.TimeSlot;
import models.animals.Animal;

public interface AppointmentAnimalCreationStrategy {

    Animal getNewAppointmentAnimal(TimeSlot appointmentTime);

}
