package models;

import enums.AppointmentLengthInMinutesByTypeEnum;
import enums.RandomEnumLogicClass;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildAnimalAppointment extends Appointment {
    private static final SecureRandom random = new SecureRandom();
    private static final List<String> doctorsNamesList  = new ArrayList<>(Arrays.asList("Andy Fang", "Lewis Talon", "Peter Tooth", "Lauren Tail", "Oliver Tail"));
    String appointmentTypeName;


    @Override
    public String getDoctorsName() {
        int randomDoctorIndex = random.nextInt(doctorsNamesList.size());
        return doctorsNamesList.get(randomDoctorIndex);
    }

    @Override
    public String getTypeOfAppointment() {
        AppointmentLengthInMinutesByTypeEnum appointmentType = RandomEnumLogicClass.
                randomEnum(AppointmentLengthInMinutesByTypeEnum.class);
        appointmentTypeName = appointmentType.name();
        return appointmentTypeName;
    }

    @Override
    public Duration getLengthOfAppointmentInMinutes() {
        return Duration.ofMinutes(AppointmentLengthInMinutesByTypeEnum
                .valueOf(appointmentTypeName.toUpperCase())
                .getAppointmentLengthInMinutes());
    }

    @Override
    public boolean isEmergencyAppointment() {
        return true;
    }
}
