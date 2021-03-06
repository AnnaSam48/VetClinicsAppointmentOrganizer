package generators.strategies;


import models.TimeSlot;
import models.animals.Animal;

public interface AppointmentStrategy {

    Animal getNewAppointmentAnimal(TimeSlot appointmentTime);

}
