package generators.appointmentFactory;

import models.appointments.Appointment;
import models.appointments.PrebookedAppointment;

public class NonEmergencyAppointmentFactory extends AppointmentFactory {
    @Override
    public Appointment createAppointment() {
        return new PrebookedAppointment();
    }
}
