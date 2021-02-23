package generators.strategies;

import models.appointments.Appointment;
import models.appointments.EmergencyAppointment;
import models.appointments.PrebookedAppointment;

import java.time.LocalTime;

public class AppointmentFactory {

    public Appointment createAppointment(LocalTime appointmentTimeRangeStart, LocalTime appointmentTimeRangeFinish) {
        if(appointmentTimeRangeStart == LocalTime.of(9,00) &&
        appointmentTimeRangeFinish == LocalTime.of(11, 30)){
            return new EmergencyAppointment();
        }else {
            return new PrebookedAppointment();
        }
    }
}
