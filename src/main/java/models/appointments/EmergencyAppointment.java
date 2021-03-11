package models.appointments;


import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;

public class EmergencyAppointment extends Appointment {


    public EmergencyAppointment(String appointmentType, TimeSlot appointmentTimeSlot, VeterinaryDoctor veterinaryDoctor, Animal animal) {
        super(appointmentType, appointmentTimeSlot, veterinaryDoctor, animal);
    }
}
