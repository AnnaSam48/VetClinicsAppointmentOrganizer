package models;


import java.time.Duration;
import java.time.LocalTime;

public abstract class Appointment {

    protected String doctorsName;
    protected Duration lengthOfAppointmentInMinutes;
    protected String typeOfAppointment;
    protected boolean isEmergencyAppointment;


    public abstract String getDoctorsName();

    public abstract Duration getLengthOfAppointmentInMinutes();

    public abstract String getTypeOfAppointment();

    public abstract boolean isEmergencyAppointment();
}
