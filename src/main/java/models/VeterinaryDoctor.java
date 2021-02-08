package models;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class VeterinaryDoctor {

    private String nameSurname;
    private String experienceLevel;
    private List<String> daysWhenWork;
    private Duration workPeriod;
    private LocalTime workFinishedAt;
    private boolean isAvailable;

    public VeterinaryDoctor() {
    }

    public VeterinaryDoctor(String nameSurname, String experienceLevel, List<String> daysWhenWork, Duration workPeriod, LocalTime workFinishedAt) {
        this.nameSurname = nameSurname;
        this.experienceLevel = experienceLevel;
        this.daysWhenWork = daysWhenWork;
        this.workPeriod = workPeriod;
        this.workFinishedAt = workFinishedAt;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public List<String> getDaysWhenWork() {
        return daysWhenWork;
    }

    public void setDaysWhenWork(List<String> daysWhenWork) {
        this.daysWhenWork = daysWhenWork;
    }

    public Duration getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Duration workPeriod) {
        this.workPeriod = workPeriod;
    }

    public LocalTime getWorkFinishedAt() {
        return workFinishedAt;
    }

    public void setWorkFinishedAt(LocalTime workFinishedAt) {
        this.workFinishedAt = workFinishedAt;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}
