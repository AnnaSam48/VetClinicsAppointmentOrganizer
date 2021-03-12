package factories.appointmentFactory;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;
import models.appointments.EmergencyAppointment;

public class EmergencyAppointmentFactory extends AppointmentFactory{

    @Override
    public Appointment createAppointment(String appointmentType, TimeSlot appointmentTimeSlot, VeterinaryDoctor veterinaryDoctor, Animal animal) {
        return new EmergencyAppointment(appointmentType, appointmentTimeSlot, veterinaryDoctor, animal);
    }
}
