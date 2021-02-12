package generators;

import models.Appointment;

abstract public class AppointmentFactory {

    public void getCreatedAppointment(){
        Appointment appointmentCreated = createAppointment();

    }

    public abstract Appointment createAppointment();
}
