package factories.appointmentFactory;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;

abstract public class AppointmentFactory {

    String appointmentType;
    TimeSlot appointmentTimeSlot;
    VeterinaryDoctor veterinaryDoctor;
    Animal animal;
    public abstract Appointment createAppointment(String appointmentType, TimeSlot appointmentTimeSlot, VeterinaryDoctor veterinaryDoctor, Animal animal);
}
