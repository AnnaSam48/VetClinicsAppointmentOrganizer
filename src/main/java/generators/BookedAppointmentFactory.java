package generators;

import models.PrebookedAppointment;

public class BookedAppointmentFactory extends AppointmentFactory {
    @Override
    public PrebookedAppointment createAppointment() {
        return new PrebookedAppointment();
    }
}
