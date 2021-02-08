package models;

import java.time.Duration;
import java.time.LocalTime;

public class Appointment {

    private Duration lengthOfAppointmentInMinutes;
    private Animal animal;
    private String doctorsName;
    private LocalTime timeOfAppointment;
    private LocalTime endTimeOfAppoiintment;
    private String typeOfAppointment;
    private boolean isAnimalWild;

    public Appointment() {
    }

    public Appointment(Duration lengthOfAppointmentInMinutes, Animal animal, String doctorsName,
                       LocalTime timeOfAppointment, LocalTime endTimeOfAppoiintment, String typeOfAppointment,
                       boolean isAnimalWild) {
        this.lengthOfAppointmentInMinutes = lengthOfAppointmentInMinutes;
        this.animal = animal;
        this.doctorsName = doctorsName;
        this.timeOfAppointment = timeOfAppointment;
        this.endTimeOfAppoiintment = endTimeOfAppoiintment;
        this.typeOfAppointment = typeOfAppointment;
        this.isAnimalWild = isAnimalWild;
    }

    public Duration getLengthOfAppointmentInMinutes() {
        return lengthOfAppointmentInMinutes;
    }

    public void setLengthOfAppointmentInMinutes(Duration lengthOfAppointmentInMinutes) {
        this.lengthOfAppointmentInMinutes = lengthOfAppointmentInMinutes;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public LocalTime getEndTimeOfAppoiintment() {
        return endTimeOfAppoiintment;
    }

    public void setEndTimeOfAppoiintment(LocalTime endTimeOfAppoiintment) {
        this.endTimeOfAppoiintment = endTimeOfAppoiintment;
    }

    public String getTypeOfAppointment() {
        return typeOfAppointment;
    }

    public void setTypeOfAppointment(String typeOfAppointment) {
        this.typeOfAppointment = typeOfAppointment;
    }

    public boolean isAnimalWild() {
        return isAnimalWild;
    }

    public void setAnimalWild(boolean animalWild) {
        isAnimalWild = animalWild;
    }
}
