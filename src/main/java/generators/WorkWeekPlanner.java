package generators;

import enums.WorkWeekDayEnum;
import models.Planner;
import models.VeterinaryDoctor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WorkWeekPlanner {
    static final LocalTime WORKDAY_START = LocalTime.of(9, 00);

    List<VeterinaryDoctor> doctorsList = Arrays.asList(
            new VeterinaryDoctor("Andy Fang",
                    "junior doctor", Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday"),
                    java.time.Duration.ofHours(4), (WORKDAY_START.plusHours(4))),
            new VeterinaryDoctor("Lewis Talon",
                    "retiring doctor", Arrays.asList("Monday", "Wednesday", "Friday"),
                    java.time.Duration.ofHours(5), WORKDAY_START.plusHours(5)),
            new VeterinaryDoctor("Peter Tooth",
                    "senior doctor", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
                    java.time.Duration.ofHours(9), WORKDAY_START.plusHours(9)),
            new VeterinaryDoctor("Lauren Tail",
                    "senior doctor", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
                    java.time.Duration.ofHours(9), WORKDAY_START.plusHours(9)),
            new VeterinaryDoctor("Oliver Tail",
                    "senior doctor", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
                    java.time.Duration.ofHours(9), WORKDAY_START.plusHours(9)));


    public List<String> workDaysList = new ArrayList<>();
    public WorkWeekDayEnum[] workWeekDayEnums = WorkWeekDayEnum.values();

    public List<String> getWorkDaysList() {
        for (WorkWeekDayEnum day : workWeekDayEnums) {
            workDaysList.add(day.toString());
        }
        return workDaysList;
    }

    public Planner getPlannerWithNoBookedAppointments() {
        Planner planner = new Planner();
        for (String workday : workDaysList) {
            planner.setDay(workday);
            planner.setWorkdayStartTime(WORKDAY_START);
            planner.setDoctors(doctorsList);
            for (VeterinaryDoctor doctor : planner.getDoctors()) {
                if (doctor.getNameSurname().equals("Lewis Talon") &&
                        (workday.equalsIgnoreCase("Tuesday")
                                || workday.equalsIgnoreCase("Thursday"))) {
                    doctor.setIsAvailable(false);


                } else if (doctor.getNameSurname().equals("Andy Fang") &&
                        workday.equalsIgnoreCase("Thursday")) {

                    doctor.setIsAvailable(false);

                } else {

                    doctor.setIsAvailable(true);
                }

                planner.setAvailable(doctor.getIsAvailable());
            }
        }
        return planner;
    }
}

