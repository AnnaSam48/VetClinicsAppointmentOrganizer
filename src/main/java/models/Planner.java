package models;

import models.animals.Animal;
import models.appointments.Appointment;

import java.util.List;

public class Planner {

    private VeterinaryDoctor doctor;
    private List<VeterinaryDoctor> veterinaryDoctorsList;
    private TimeSlot timeSlot;
    private List<TimeSlot> timeslotList;
    private Appointment appointment;
    private List<Appointment> appointmentList;


    public Planner() {
    }

    public Planner(VeterinaryDoctor doctor,
                   TimeSlot timeSlot, Appointment appointment) {

        this.doctor = doctor;
        this.timeSlot = timeSlot;
        this.appointment = appointment;
    }


    public VeterinaryDoctor getVeterinaryDoctor() {
        return doctor;
    }

    public void setVeterinaryDoctor(VeterinaryDoctor doctor) {
        this.doctor = doctor;
    }

    public List<VeterinaryDoctor> getVeterinaryDoctorsList() {
        return veterinaryDoctorsList;
    }

    public void setVeterinaryDoctorsList(List<VeterinaryDoctor> veterinaryDoctorsList) {
        this.veterinaryDoctorsList = veterinaryDoctorsList;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<TimeSlot> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<TimeSlot> timeslotList) {
        this.timeslotList = timeslotList;
    }

}
