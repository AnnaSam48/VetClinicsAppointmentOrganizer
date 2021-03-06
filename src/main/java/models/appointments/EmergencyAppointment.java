package models.appointments;


import enums.AppointmentTypeEnum;
import enums.RandomEnumLogicClass;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;


public class EmergencyAppointment extends Appointment {

    @Override
    TimeSlot setAppointmentTimeslot(TimeSlot timeSlot) {
        return timeSlot;
    }

    @Override
    String getAppointmentType() {
        AppointmentTypeEnum appointmentType = RandomEnumLogicClass.
                randomEnum(AppointmentTypeEnum.class);
        return appointmentType.name();
    }

    @Override
    Animal setAnimalForAppointment(Animal animalForAppointment) {
        return animalForAppointment;
    }

    @Override
    VeterinaryDoctor setDoctorForAppointment(VeterinaryDoctor doctor) {
        return doctor;
    }
}
