package models;


import java.time.Duration;
import java.time.LocalTime;

public abstract class Appointment {

    protected String doctorsName;
    protected Duration lengthOfAppointmentInMinutes;
    protected String typeOfAppointment;
    protected boolean isEmergencyAppointment;


    public abstract void getDoctorsName();

    public abstract void getLengthOfAppointmentInMinutes();

    public abstract void getTypeOfAppointment();

    public abstract void isEmergencyAppointment();


}
