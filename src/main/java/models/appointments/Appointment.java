package models.appointments;


import models.animals.Animal;

import java.time.Duration;
import java.time.LocalTime;

public abstract class Appointment {

    protected String doctorsName;
    protected Animal animal;
    protected LocalTime timeOfAppointment;
    protected Duration lengthOfAppointmentInMinutes;
    protected String typeOfAppointment;
    protected boolean isEmergencyAppointment;


    public abstract void setDoctorsName(String doctorsName);

    public abstract void setAnimal(Animal animal);

    public abstract void setTimeOfAppointment(LocalTime timeOfAppointment);

    public abstract void setLengthOfAppointmentInMinutes(Duration lengthOfAppointmentInMinutes);

    public abstract void setTypeOfAppointment(String typeOfAppointment);

    public abstract void setIsEmergencyAppointment();

}
