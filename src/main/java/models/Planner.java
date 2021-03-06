package models;

import models.appointments.Appointment;

import java.util.List;

public class Planner {

    private String day;
    private List<String> daysList;
    private VeterinaryDoctor doctor;
    private List<VeterinaryDoctor> veterinaryDoctorsList;
    private TimeSlot timeSlot;
    private List<TimeSlot> timeslotList;
    private Appointment appointment;
    private List<Appointment> appointmentList;
    private boolean available;

    public Planner() {
    }

    public Planner(String day, VeterinaryDoctor doctor,
                   TimeSlot timeSlot, Appointment appointment, boolean available) {

        this.day = day;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
        this.appointment = appointment;
        this.available = available;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getDaysList() {
        return daysList;
    }

    public void setDaysList(List<String> daysList) {
        this.daysList = daysList;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<TimeSlot> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<TimeSlot> timeslotList) {
        this.timeslotList = timeslotList;
    }
}
