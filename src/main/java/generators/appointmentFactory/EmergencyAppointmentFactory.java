package generators.appointmentFactory;

import models.appointments.Appointment;
import models.appointments.EmergencyAppointment;

public class EmergencyAppointmentFactory extends AppointmentFactory{
    @Override
    public Appointment createAppointment() {
        return new EmergencyAppointment();
    }
}
