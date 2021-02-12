package generators;

import models.EmergencyAppointment;

public class EmergencyAppointmentFactory extends AppointmentFactory {
    @Override
    public EmergencyAppointment createAppointment() {
        return new EmergencyAppointment();
    }
}
