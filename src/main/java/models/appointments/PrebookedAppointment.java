package models.appointments;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;


public class PrebookedAppointment extends Appointment {

    public PrebookedAppointment(String appointmentType, TimeSlot appointmentTimeSlot, VeterinaryDoctor veterinaryDoctor, Animal animal) {
        super(appointmentType, appointmentTimeSlot, veterinaryDoctor, animal);
    }
}
