package generators.appointmentFactories;

import generators.appointmentFactories.AppointmentFactory;
import models.appointments.EmergencyAppointment;

public class EmergencyAppointmentFactory extends AppointmentFactory {
    @Override
    public EmergencyAppointment createAppointment() {
        return new EmergencyAppointment();
    }
}
