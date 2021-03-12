package factories.appointmentFactory;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;
import models.appointments.PrebookedAppointment;

public class NonEmergencyAppointmentFactory extends AppointmentFactory {


    @Override
    public Appointment createAppointment(String appointmentType, TimeSlot appointmentTimeSlot, VeterinaryDoctor veterinaryDoctor, Animal animal) {
        return new PrebookedAppointment(appointmentType, appointmentTimeSlot, veterinaryDoctor, animal);
    }
}
