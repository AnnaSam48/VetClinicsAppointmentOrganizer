package models;


import models.appointments.Appointment;

import java.time.LocalTime;
import java.util.List;

public class Planner {

    private List<String> allWorkdays;
    private String day;
    private List<VeterinaryDoctor> doctors;
    private LocalTime workdayStartTime;
    private Appointment appointment;
    private LocalTime workdayEndTimeForFullTimeDoctors;
    private List<Appointment> appointmentList;
    private boolean available;

    public Planner() {
    }

    public Planner( String day, List<VeterinaryDoctor> doctors, LocalTime workdayStartTime,
                   LocalTime workdayEndTimeForFullTimeDoctors, Appointment appointment, boolean available) {

        this.day = day;
        this.doctors = doctors;
        this.workdayStartTime = workdayStartTime;
        this.workdayEndTimeForFullTimeDoctors = workdayEndTimeForFullTimeDoctors;
        this.appointment = appointment;
        this.available = available;
    }

    public List<String> getAllWorkdays() {
        return allWorkdays;
    }

    public void setAllWorkdays(List<String> allWorkdays) {
        this.allWorkdays = allWorkdays;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<VeterinaryDoctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<VeterinaryDoctor> doctors) {
        this.doctors = doctors;
    }

    public LocalTime getWorkdayStartTime() {
        return workdayStartTime;
    }

    public void setWorkdayStartTime(LocalTime workdayStartTime) {
        this.workdayStartTime = workdayStartTime;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalTime getWorkdayEndTimeForFullTimeDoctors() {
        return workdayEndTimeForFullTimeDoctors;
    }

    public void setWorkdayEndTimeForFullTimeDoctors(LocalTime workdayEndTimeForFullTimeDoctors) {
        this.workdayEndTimeForFullTimeDoctors = workdayEndTimeForFullTimeDoctors;
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
}
