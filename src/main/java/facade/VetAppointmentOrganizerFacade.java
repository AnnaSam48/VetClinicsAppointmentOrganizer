package facade;

import enums.AppointmentLengthInMinutesByTypeEnum;
import enums.RandomEnumLogicClass;
import generators.WorkWeekPlanner;
import generators.strategies.AppointmentFactory;
import models.Planner;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VetAppointmentOrganizerFacade {

    private Animal animal;
    private VeterinaryDoctor veterinaryDoctor;
    private Planner weekPlanner;
    private static final WorkWeekPlanner workPlanner = new WorkWeekPlanner();
    private static final SecureRandom random = new SecureRandom();
    private static final LocalTime EMERGENCY_APPOINTMENT_TIME_START = LocalTime.of(9,00);
    //The emergency appointments can be till 12:00, but they can only be made till 11:30 as 30 minutes is the shortest possible appointment
    private static final LocalTime EMERGENCY_APPOINTMENT_TIME_FINISH = LocalTime.of(11,30);
    private static final LocalTime BOOKED_APPOINTMENT_TIME_START = LocalTime.of(12,00);
    //The appointments can be till 18:00, but they can only be made till 17:30 as 30 minutes is the shortest possible appointment
    private static final LocalTime BOOKED_APPOINTMENT_START_TIME = LocalTime.of(18, 00);
    Planner newPlanner = getWeekPlannerWithAllAvailableDays();
    List<Appointment> bookedAppointmentList = new ArrayList<>();
    private AppointmentFactory appointmentFactory = new AppointmentFactory();
    /*TODO: appointment logic:
    Create random appointment (time first -> doctor -> animal)
    Set appointment following logic:
    1)Check the appointment list first if given doctor is available in given time
    (work hours and prior appointments)
    2) then generate animal:
    if hours between 09.00 - 12.00 then emergency animal generation logic (at least 5 wild animals,
     after wild and domestic animals can be generated)
     3) set appointment details (?what to do with different workdays)


     !Idea for emergency appointments - make random time between 9.00-12.00 therefore no need to check
     doctors hours only isAvailable.

     Observer: Needs to notify if:
     1) The max amount of appointments for the day is reached (when five doctors available in the day
     30 max, when less doctors for each doctor missing -6 appointments)
     2)when appointments for the week are all booked
     */
    //TODO: Make a list of existing appointments -> focus on time slots time:doctor


    public void bookAppointment(){

        List<VeterinaryDoctor> doctorsList = newPlanner.getDoctors();
        List<String> daysList = newPlanner.getAllWorkdays();
        LocalTime workDayStartTime =newPlanner.getWorkdayStartTime();

        for(String day : daysList){
            for(VeterinaryDoctor doctor : doctorsList){
                if(newPlanner.isAvailable()){
                    //generate emergency appointments 09:00-11.30
                    Appointment newAppointment = appointmentFactory.createAppointment(EMERGENCY_APPOINTMENT_TIME_START, EMERGENCY_APPOINTMENT_TIME_FINISH);
                    newAppointment.setTimeOfAppointment(getRandomAppointmentTime(EMERGENCY_APPOINTMENT_TIME_START, EMERGENCY_APPOINTMENT_TIME_FINISH));
                    newAppointment.setTypeOfAppointment(getRandomAppointmentType());
                    newAppointment.setLengthOfAppointmentInMinutes();
                    newAppointment.setAppointmentEndTime();
                    newAppointment.setIsEmergencyAppointment();
                    newAppointment.setDoctorsName();
                    newAppointment.setAnimal();
                    bookedAppointmentList.add(newAppointment);

                }
            }
        }





    }

    private Animal getRandomAnimal(){
        return null;
    }

    protected LocalTime getRandomAppointmentTime(LocalTime timeRangeStart, LocalTime timeRangeFinish) {
        int secondsOfAppointmentRangeStartTime = (timeRangeStart.toSecondOfDay());
        int secondsOfAppointmentRangeFinishTime = (timeRangeFinish.toSecondOfDay());
        int randomAppointmentTimeInSeconds = secondsOfAppointmentRangeStartTime +
                random.nextInt(secondsOfAppointmentRangeFinishTime - secondsOfAppointmentRangeStartTime);
        return LocalTime.ofSecondOfDay(randomAppointmentTimeInSeconds).truncatedTo(ChronoUnit.MINUTES);
    }
    protected VeterinaryDoctor getRandomAvailableDoctor(List<VeterinaryDoctor> availableDoctors,
                                                        List<Appointment> alreadyExistingAppointmentList){
        int randomDoctorIndex = random.nextInt(availableDoctors.size());
        return availableDoctors.get(randomDoctorIndex);
    }

    public Planner getWeekPlannerWithAllAvailableDays(){
        weekPlanner = workPlanner.getPlannerWithNoBookedAppointments();
        System.out.print(weekPlanner.toString());
        return weekPlanner;
    }
    public List<VeterinaryDoctor> getPartTimeDoctors(){
        //get part time doctors list
        return weekPlanner.getDoctors().stream().filter(doctor -> doctor
                .getWorkPeriod().compareTo(Duration.ofHours(9)) <0).collect(Collectors.toList());
    }

    public String getRandomAppointmentType() {
        AppointmentLengthInMinutesByTypeEnum appointmentType = RandomEnumLogicClass.
                randomEnum(AppointmentLengthInMinutesByTypeEnum.class);
        return appointmentType.name();
    }
}

/*
int secondsOfEmergencyStartTime = (EMERGENCY_APPOINTMENT_TIME_START.toSecondOfDay());
        int minutesOfEmergencyFinishTime = (EMERGENCY_APPOINTMENT_TIME_FINISH.toSecondOfDay());
        int randomAppointmentTimeInSeconds = secondsOfEmergencyStartTime +
                random.nextInt(minutesOfEmergencyFinishTime -secondsOfEmergencyStartTime);
        return LocalTime.ofSecondOfDay(randomAppointmentTimeInSeconds).truncatedTo(ChronoUnit.MINUTES);
* */

