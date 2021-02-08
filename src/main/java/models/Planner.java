package models;


import java.time.LocalTime;
import java.util.List;

public class Planner {

   private String day;
   private List<VeterinaryDoctor> doctors;
   private LocalTime workdayStartTime;

    public Planner() {
    }

    public Planner(String day, List<VeterinaryDoctor> doctors, LocalTime workdayStartTime) {
        this.day = day;
        this.doctors = doctors;
        this.workdayStartTime = workdayStartTime;
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
}
