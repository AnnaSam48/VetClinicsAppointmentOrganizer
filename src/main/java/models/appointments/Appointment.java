package models.appointments;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;

public abstract class Appointment {

    protected String appointmentType;
    protected TimeSlot appointmentTimeslot;
    protected boolean isAvailable;

    abstract String getAppointmentType();
    abstract TimeSlot setAppointmentTimeslot(TimeSlot appointmentTimeslot);
    abstract Animal setAnimalForAppointment(Animal animalForAppointment);
    abstract VeterinaryDoctor setDoctorForAppointment(VeterinaryDoctor doctor);


}
