package models.appointments;

import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;



public abstract class Appointment {

    private String appointmentType;
    private TimeSlot appointmentTimeSlot;
    private VeterinaryDoctor veterinaryDoctor;
    private Animal animal;

    public Appointment (String appointmentType, TimeSlot appointmentTimeSlot,
                        VeterinaryDoctor veterinaryDoctor, Animal animal){
        this.appointmentType = appointmentType;
        this.appointmentTimeSlot = appointmentTimeSlot;
        this.veterinaryDoctor = veterinaryDoctor;
        this.animal = animal;
    }

    public String getAppointmentType(){
        return appointmentType;
    }

    public TimeSlot getAppointmentTimeSlot(){
        return  appointmentTimeSlot;
    }

    public VeterinaryDoctor getVeterinaryDoctor(){
        return veterinaryDoctor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

  //  public String getAnimalName(Animal animal){
   // }

}
