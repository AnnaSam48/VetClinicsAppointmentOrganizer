package generators.appointmentFactories;

import generators.appointmentFactories.AppointmentFactory;
import models.appointments.PrebookedAppointment;

public class BookedAppointmentFactory extends AppointmentFactory {
    @Override
    public PrebookedAppointment createAppointment() {
        return new PrebookedAppointment();
    }
}
