package models.appointments;

import enums.AppointmentTypeEnum;
import enums.RandomEnumLogicClass;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PrebookedAppointment extends Appointment {

    private static final SecureRandom timeSlotRandom = new SecureRandom();

    private List<TimeSlot> getTimeSlotList () {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        for (int i = 3; i < 9; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlotNumber(i + 1);
            String timeslotName = "Timeslot " + (i+1);
            timeSlot.setSlotName(timeslotName);
            timeSlot.setIsAvailable(true);
            timeSlotList.add(timeSlot);
        }
        return timeSlotList;
    }

    @Override
    TimeSlot getAppointmentTimeslot() {
        int randomTimeslotIndex = timeSlotRandom.nextInt(getTimeSlotList().size());
        return getTimeSlotList().get(randomTimeslotIndex);
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
