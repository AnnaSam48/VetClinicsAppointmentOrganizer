package models;

import java.time.Duration;
import java.time.LocalTime;


public class PrebookedAppointment extends Appointment {

    @Override
    public void setDoctorsName(String doctorsNameSurname) {
       this.doctorsName = doctorsNameSurname;
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }


    @Override
    public void setTypeOfAppointment(String appointmentTypeName) {
        this.typeOfAppointment = appointmentTypeName;

    }

    @Override
    public void setLengthOfAppointmentInMinutes(Duration lengthOfAppointment) {
        this.lengthOfAppointmentInMinutes = lengthOfAppointment;
    }

    @Override
    public void setIsEmergencyAppointment() {
        this.isEmergencyAppointment = false;
    }
}
