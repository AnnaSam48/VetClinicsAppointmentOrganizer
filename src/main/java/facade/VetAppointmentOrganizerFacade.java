package facade;

import enums.WorkWeekDayEnum;
import generators.WorkWeekPlanner;
import models.Planner;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;

import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VetAppointmentOrganizerFacade {

    private Animal animal;
    private VeterinaryDoctor veterinaryDoctor;
    private Planner weekPlanner;
    private static final WorkWeekPlanner workPlanner = new WorkWeekPlanner();
    private static final SecureRandom random = new SecureRandom();
    List<Appointment> bookedAppointmentList = new ArrayList<>();

    /*TODO: appointment logic:
    Create random appointment (time first -> doctor -> animal)
    Set appointment following logic:
    1)Check the appointment list first if given doctor is available in given time
    (work hours and prior appointments)
    2) then generate animal:
    if hours between 09.00 - 12.00 then emergency animal generation logic (at least 5 wild animals,
     after wild and domestic animals can be generated)

    Necessary info for Appointment:
    1)Timeslot random generated
    2)Doctor random generated - if doctor has appointment set isAvailable to false
    3)Appointment type
    4)Animal random depends on timeslot


     !Idea for emergency appointments - make random time between 9.00-12.00 therefore no need to check
     doctors hours only isAvailable.

     Observer: Needs to notify if:
     1) The max amount of appointments for the day is reached (when five doctors available in the day
     30 max, when less doctors for each doctor missing -6 appointments)
     2)when appointments for the week are all booked

    //TODO: Make a list of existing appointments -> focus on time slots time:doctor

*/
    public void bookAppointment(){

        Planner newPlanner = getWeekPlanner();






    }

    public Planner getWeekPlanner(){
        Planner newWeekPlanner = new Planner();
        newWeekPlanner.setDaysList(getWorkDaysList());
        newWeekPlanner.setVeterinaryDoctorsList(getAllDoctors());
        newWeekPlanner.setTimeslotList(getAllAppointmentTimeSlotList());
        for(String workday : getWorkDaysList()){
            newWeekPlanner.setDay(workday);
            for(VeterinaryDoctor doctor : getAllDoctors()){
                newWeekPlanner.setVeterinaryDoctor(doctor);
                for (TimeSlot appointmentTimeSlot : getAllAppointmentTimeSlotList()){
                    appointmentTimeSlot.setDoctorsName(doctor.getNameSurname());
                    newWeekPlanner.setTimeSlot(appointmentTimeSlot);
                }
            }
        }
        return newWeekPlanner;
    }

    public List<String> getWorkDaysList() {
        List<String> workDaysList = new ArrayList<>();
        WorkWeekDayEnum[] workWeekDayEnums = WorkWeekDayEnum.values();
        for (WorkWeekDayEnum day : workWeekDayEnums) {
            workDaysList.add(day.toString());
        }
        return workDaysList;
    }

    protected List<VeterinaryDoctor> getAllDoctors(){
        return Arrays.asList(
                new VeterinaryDoctor("Peter Tooth"),
                new VeterinaryDoctor("Lauren Tail"),
                new VeterinaryDoctor("Oliver Tail"));
    }

    protected List<TimeSlot> getAllAppointmentTimeSlotList(){
        List<TimeSlot> timeSlotList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlotNumber(i + 1);
            String timeslotName = "Timeslot " + (i+1);
            timeSlot.setSlotName(timeslotName);
            timeSlot.setIsAvailable(true);
            timeSlotList.add(timeSlot);
        }
        return timeSlotList;
    }

    protected TimeSlot getRandomTimeslot(){
        int randomTimeslotIndex = random.nextInt(getAllAppointmentTimeSlotList().size());
        return getAllAppointmentTimeSlotList().get(randomTimeslotIndex);
    }

    protected VeterinaryDoctor getRandomAvailableDoctor(List<VeterinaryDoctor> availableDoctors){
        int randomDoctorIndex = random.nextInt(availableDoctors.size());
        return availableDoctors.get(randomDoctorIndex);
    }

    public void printEmptyPlanner(){
      getWeekPlanner().getDaysList().forEach(day -> System.out.print("                                      "
              + day +
              "                                 ||                           " ));
        System.out.println();
        System.out.println("================================================================="
                +"======================================================================================================"
                + "====================================================================================================="
                + "====================================================================================================="
                + "=====================================================================================================");
        getWeekPlanner().getDaysList()
                .forEach(day -> getWeekPlanner().getVeterinaryDoctorsList()
                        .forEach(doctor -> {System.out.print("             " +doctor.getNameSurname() + "    || ");}));
        System.out.println();
        System.out.println("================================================================="
                +"======================================================================================================"
                + "====================================================================================================="
                + "====================================================================================================="
                + "=====================================================================================================");
        getWeekPlanner().getDaysList()
                .forEach(day -> getWeekPlanner().getVeterinaryDoctorsList()
                        .forEach(doctor -> getWeekPlanner().getTimeslotList()
                                .forEach(timeSlot -> {
            System.out.print(timeSlot.getSlotName() + " || ");
                                    getWeekPlanner().getDaysList().forEach(dayInList -> getWeekPlanner()
                                            .getVeterinaryDoctorsList()
                                            .forEach(doctor1 -> System.out.print(" " + timeSlot.getIsAvailable() + " || ")));
                                    System.out.println();
                                    System.out.println("================================================================="
                                            +"======================================================================================================"
                                            + "====================================================================================================="
                                            + "====================================================================================================="
                                            + "=====================================================================================================");

        })));


    }

}


