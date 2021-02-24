package generators;

import enums.WorkWeekDayEnum;
import generators.animalFactories.AnimalFactory;
import generators.animalFactories.WildAnimalFactory;
import models.Planner;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WorkWeekPlanner {
    static final LocalTime WORKDAY_START = LocalTime.of(9, 00);
    static final LocalTime WORKDAY_END_PART_TIME = LocalTime.of(14,00);
    static final LocalTime WORKDAY_END_FULL_TIME = LocalTime.of(18,00);
    private static final SecureRandom random = new SecureRandom();

    List<VeterinaryDoctor> doctorsList = Arrays.asList(
        /*    new VeterinaryDoctor("Andy Fang",
                    "junior doctor", Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday"),
                    java.time.Duration.ofHours(5), (WORKDAY_START.plusHours(5))),
            new VeterinaryDoctor("Lewis Talon",
                    "retiring doctor", Arrays.asList("Monday", "Wednesday", "Friday"),
                    java.time.Duration.ofHours(5), WORKDAY_START.plusHours(5)),
        */    new VeterinaryDoctor("Peter Tooth",
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
    private List<TimeSlot> getTimeSlotList () {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlotNumber(i + 1);
            String timeslotName = "Timeslot " + (i+1);
            timeSlot.setSlotName(timeslotName);
            timeSlotList.add(timeSlot);
        }
        return timeSlotList;
    }


    public List<String> getWorkDaysList() {
        for (WorkWeekDayEnum day : workWeekDayEnums) {
            workDaysList.add(day.toString());
        }
        return workDaysList;
    }

    public Planner getPlannerWithNoBookedAppointments() {
        Planner planner = new Planner();
        planner.setAllWorkdays(getWorkDaysList());

        for (String workday : getWorkDaysList()) {
            planner.setDay(workday);
            planner.setWorkdayStartTime(WORKDAY_START);
            planner.setDoctors(doctorsList);

  /*          for (VeterinaryDoctor doctor : planner.getDoctors()) {

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
            } */
        }
        return planner;
    }

    public void printPlanner(){
        WildAnimalFactory wildAnimalFactory = new WildAnimalFactory();


        System.out.println("╔" + "════════════" + "╦" + "════════════════════════════════════════════════════════" + "╦" + "════════════════════════════════════════════════════════" + "╗");
        System.out.println("╠" + "════════════" + "╣" + "                         " + getWorkDaysList().get(0) + "                         " + "║" + "                        " + getWorkDaysList().get(1) + "                         " + "║");
        System.out.println("╠" + "════════════" + "╬" + "════════════════════" + "╦" + "═══════════════════" + "╦"+"═══════════════" + "╬" + "════════════════════" + "╦" + "═══════════════════" + "╦" + "═══════════════" + "╣");
        System.out.println("║" + "    Time    " + "║" + "   " + doctorsList.get(0).getNameSurname() + "      " + "║" + "    " + doctorsList.get(1).getNameSurname() + "    " + "║" + "  " + doctorsList.get(2).getNameSurname() + "  " + "║"
                + "   " + doctorsList.get(0).getNameSurname() + "      " + "║" + "    " + doctorsList.get(1).getNameSurname() + "    " + "║" + "   " + doctorsList.get(2).getNameSurname() + " "+ "║");
        System.out.println("╠" + "════════════" + "╬" + "════════════════════" + "╩" + "═══════════════════" + "╩" + "═══════════════" + "╩" + "════════════════════" + "╩" + "═══════════════════" + "╩" + "═══════════════" + "╣");
        for(int i =0; i<17; i++){
            if(i==0 || i%2==0){

                System.out.println("║" + " " + getTimeSlotList().get(i).getSlotName() + " " + "║" + " " + wildAnimalFactory.createAnimal().getAnimal() + " " + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║");
            } else{
                System.out.println("╠" + "════════════" +  "╬" + "═════════════════════════════════════════════════════════════════════════════════════════════════════════════════" + "╣");
            }
        }
        System.out.println("╚" + "════════════" + "╩" + "═════════════════════════════════════════════════════════════════════════════════════════════════════════════════" + "╝" );
    }

}

