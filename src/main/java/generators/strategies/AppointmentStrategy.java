package generators.strategies;

import models.animals.Animal;
import models.appointments.Appointment;

import java.time.Duration;
import java.time.LocalTime;

public interface AppointmentStrategy {

     Appointment createAppointment(String doctorsName, Animal animal, LocalTime timeOfAppointment, String typeOfAppointment,
                                         Duration lengthOfAppointment, LocalTime appointmentEndTime,
                                         boolean isEmergencyAppointment);
}
