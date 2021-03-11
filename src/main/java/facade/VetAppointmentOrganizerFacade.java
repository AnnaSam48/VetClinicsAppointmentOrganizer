package facade;

import enums.AppointmentTypeEnum;
import enums.RandomEnumLogicClass;
import generators.appointmentFactory.AppointmentFactory;
import generators.appointmentFactory.EmergencyAppointmentFactory;
import generators.appointmentFactory.NonEmergencyAppointmentFactory;
import generators.strategies.AppointmentStrategyForAnimalCreationContext;
import generators.strategies.EmergencyAppointmentAnimalCreationStrategy;
import generators.strategies.NonEmergencyAppointmentAnimalCreationStrategy;
import models.Planner;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VetAppointmentOrganizerFacade {

    private SecureRandom random = new SecureRandom();
    private AppointmentFactory newEmergencyAppointmentFactory = new EmergencyAppointmentFactory();
    private AppointmentFactory newNonEmergencyAppointmentFactory = new NonEmergencyAppointmentFactory();
    private AppointmentStrategyForAnimalCreationContext strategyContextForEmergencyAppointmentAnimals =
            new AppointmentStrategyForAnimalCreationContext(new EmergencyAppointmentAnimalCreationStrategy());
    private AppointmentStrategyForAnimalCreationContext strategyContextForNormalAppointmentAnimals =
            new AppointmentStrategyForAnimalCreationContext(new NonEmergencyAppointmentAnimalCreationStrategy());
    List<Appointment> bookedAppointmentList = new ArrayList<>();
    Planner newDayPlanner = new Planner();

    /*TODO: appointment logic:

    1)Check if planner is full
    2)Check if timeslot is full && check if doctor is available
    3)observer to notify when planner is full, when timeslot is full
        ?if timeslot is full take it out of timeslot list?
    4) decorator pattern for treatments?


*/
    public void bookAppointments() {
        Planner newPlanner = getDayPlanner();
        while(!isPlannerFull(newPlanner)) {
            String appointmentType = getRandomAppointmentType();
            TimeSlot appointmentTime = getRandomTimeslot(newPlanner.getTimeslotList());

            if (isTimeslotAvailable(newPlanner, appointmentTime)) {
                VeterinaryDoctor veterinaryDoc = null;
                Optional<VeterinaryDoctor> nameMatchingVet =
                        getAllDoctors().stream()
                                .filter(doctor -> doctor.getNameSurname()
                                        .equals(appointmentTime.getDoctorsName()))
                                .findFirst();
                boolean checkIfVetExists = nameMatchingVet.isPresent();
                if (checkIfVetExists) {
                    veterinaryDoc = nameMatchingVet.get();
                }


                appointmentTime.setDoctorsName(appointmentTime.getDoctorsName());
                appointmentTime.setSlotName(appointmentTime.getSlotName());
                appointmentTime.setSlotNumber(appointmentTime.getSlotNumber());
                appointmentTime.setIsAvailable(false);
                if (appointmentTime.getSlotNumber() == 1
                        || appointmentTime.getSlotNumber() == 2
                        || appointmentTime.getSlotNumber() == 3
                        || appointmentTime.getSlotNumber() == 4) {
                    //set wild animals for emergency appointments
                    Animal newGeneratedAnimal = strategyContextForEmergencyAppointmentAnimals.animalAccordingToStrategy(appointmentTime);
                    Appointment newAppointment = newEmergencyAppointmentFactory.createAppointment(appointmentType, appointmentTime, veterinaryDoc, newGeneratedAnimal);
                    bookedAppointmentList.add(newAppointment);
                    newPlanner.setAppointment(newAppointment);
                    newPlanner.setTimeSlot(appointmentTime);
                    System.out.println(newAppointment);
                } else {
                    //set domestic animals for appointment
                    Animal newGeneratedAnimal = strategyContextForNormalAppointmentAnimals.animalAccordingToStrategy(appointmentTime);
                    Appointment newAppointment = newNonEmergencyAppointmentFactory.createAppointment(appointmentType, appointmentTime, veterinaryDoc, newGeneratedAnimal);
                    bookedAppointmentList.add(newAppointment);
                    newPlanner.setAppointment(newAppointment);
                    System.out.println(newAppointment);
                }
            } else {
                System.out.println("Timeslot not available");
            }

            newPlanner.setAppointmentList(bookedAppointmentList);
        }

        bookedAppointmentList.forEach(appointment -> System.out.println(appointment.getAppointmentTimeSlot().getSlotName() + "||" +appointment.getVeterinaryDoctor().getNameSurname() + "||" + appointment.getAppointmentType() + "||" + appointment.getAnimal()));
    }


    public Planner getDayPlanner() {
        newDayPlanner.setVeterinaryDoctorsList(getAllDoctors());
        newDayPlanner.setTimeslotList(getAllAppointmentTimeSlotList());
        for (VeterinaryDoctor doctor : getAllDoctors()) {
            newDayPlanner.setVeterinaryDoctor(doctor);
        }
        for (TimeSlot appointmentTimeSlot : getAllAppointmentTimeSlotList()) {
            newDayPlanner.setTimeSlot(appointmentTimeSlot);
        }
        return newDayPlanner;
    }

    private boolean isTimeslotAvailable(Planner planner, TimeSlot timeslotToCheck) {

            List<TimeSlot> availableTimeslots = planner.getTimeslotList().stream()
                    .filter(timeSlot -> timeSlot.getSlotNumber() == timeslotToCheck.getSlotNumber()
                            && timeSlot.getDoctorsName() == timeslotToCheck.getDoctorsName()
                            && timeSlot.getIsAvailable())
                    .collect(Collectors.toList());
            if (availableTimeslots.size() != 0) {
                return true;
            } else {
                return false;
            }
    }

    public boolean isPlannerFull(Planner planner){
        if(planner.getAppointmentList() == null || planner.getAppointmentList().size() < 27){
            return false;
        } else {
            return true;
        }
    }

    protected List<VeterinaryDoctor> getAllDoctors() {
        return Arrays.asList(
                new VeterinaryDoctor("Peter Tooth"),
                new VeterinaryDoctor("Lauren Tail"),
                new VeterinaryDoctor("Oliver Tail"));
    }

    protected List<TimeSlot> getAllAppointmentTimeSlotList() {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        for(VeterinaryDoctor doctor : getAllDoctors()) {
            for (int i = 0; i < 9; i++) {
                TimeSlot timeSlot = new TimeSlot();
                timeSlot.setSlotNumber(i + 1);
                String timeslotName = "Timeslot " + (i + 1);
                timeSlot.setDoctorsName(doctor.getNameSurname());
                timeSlot.setIsAvailable(true);
                timeSlot.setSlotName(timeslotName);
                timeSlotList.add(timeSlot);
            }
        }
        return timeSlotList;
    }

    protected TimeSlot getRandomTimeslot(List<TimeSlot> timeSlotList) {
        int randomTimeslotIndex = random.nextInt(timeSlotList.size());
        return timeSlotList.get(randomTimeslotIndex);
    }

    protected List<VeterinaryDoctor> getAvailableDoctorsForTimeSlot(Planner appointmentPlanner, TimeSlot appointmentTimeslot) {
        if (appointmentPlanner.getAppointmentList() == null) {
            return getAllDoctors();
        } else {
            List<String> busyDoctorsList = appointmentPlanner
                    .getTimeslotList()
                    .stream()
                    .filter(timeSlot ->
                            timeSlot.getSlotNumber() == appointmentTimeslot.getSlotNumber()
                                    && !timeSlot.getIsAvailable())
                    .collect(Collectors.toList())
                    .stream()
                    .map(TimeSlot::getDoctorsName).collect(Collectors.toList());

            List<String> availableDoctorsNameList = getAllDoctors().stream()
                    .map(VeterinaryDoctor::getNameSurname)
                    .filter(doctor -> !busyDoctorsList.contains(doctor))
                    .collect(Collectors.toList());

            return getAllDoctors().stream().filter(vet -> availableDoctorsNameList
                    .contains(vet.getNameSurname())).collect(Collectors.toList());
        }
    }

    String getRandomAppointmentType() {
        AppointmentTypeEnum appointmentType = RandomEnumLogicClass.
                randomEnum(AppointmentTypeEnum.class);
        return appointmentType.name();
    }


    public void printEmptyPlanner() {

        getDayPlanner().getVeterinaryDoctorsList()
                .forEach(doctor -> {
                    System.out.print("             " + doctor.getNameSurname() + "    || ");
                });
        System.out.println();
        System.out.println("================================================================="
                + "======================================================================================================"
                + "====================================================================================================="
                + "====================================================================================================="
                + "=====================================================================================================");
        getDayPlanner().getVeterinaryDoctorsList()
                .forEach(doctor -> getDayPlanner().getTimeslotList()
                        .forEach(timeSlot -> {
                            System.out.print(timeSlot.getSlotName() + " || ");
                            getDayPlanner()
                                    .getVeterinaryDoctorsList()
                                    .forEach(doctor1 -> System.out.print(" " + timeSlot.getIsAvailable() + " || "));
                            System.out.println();
                            System.out.println("================================================================="
                                    + "======================================================================================================"
                                    + "====================================================================================================="
                                    + "====================================================================================================="
                                    + "=====================================================================================================");

                        }));

    }
}


