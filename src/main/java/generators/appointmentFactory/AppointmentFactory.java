package generators.appointmentFactory;

import models.appointments.Appointment;

abstract public class AppointmentFactory {
    public abstract Appointment createAppointment();
}
