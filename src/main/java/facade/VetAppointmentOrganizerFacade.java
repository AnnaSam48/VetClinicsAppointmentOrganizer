package facade;

import decoratorsOrBridge.*;
import enums.AppointmentTypeEnum;
import enums.RandomEnumLogicClass;
import factories.appointmentFactory.AppointmentFactory;
import factories.appointmentFactory.EmergencyAppointmentFactory;
import factories.appointmentFactory.NonEmergencyAppointmentFactory;
import state.PlannerStateContext;
import state.StartPlanningDay;
import state.StopPlanningDay;
import strategies.AppointmentStrategyForAnimalCreationContext;
import strategies.EmergencyAppointmentAnimalCreationStrategy;
import strategies.NonEmergencyAppointmentAnimalCreationStrategy;
import models.Planner;
import models.TimeSlot;
import models.VeterinaryDoctor;
import models.animals.Animal;
import models.appointments.Appointment;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class VetAppointmentOrganizerFacade {

    private final SecureRandom random = new SecureRandom();
    private final AppointmentFactory newEmergencyAppointmentFactory = new EmergencyAppointmentFactory();
    private final  AppointmentFactory newNonEmergencyAppointmentFactory = new NonEmergencyAppointmentFactory();
    private final AppointmentStrategyForAnimalCreationContext strategyContextForEmergencyAppointmentAnimals =
            new AppointmentStrategyForAnimalCreationContext(new EmergencyAppointmentAnimalCreationStrategy());
    private final AppointmentStrategyForAnimalCreationContext strategyContextForNormalAppointmentAnimals =
            new AppointmentStrategyForAnimalCreationContext(new NonEmergencyAppointmentAnimalCreationStrategy());
    List<Appointment> bookedAppointmentList = new ArrayList<>();
    Planner newDayPlanner = new Planner();
    PlannerStateContext context = new PlannerStateContext();

    public void bookAppointments() {
        Planner newPlanner = getDayPlanner();

        //State for purposes of having facade only prints the state, but normally would contain logic
        StartPlanningDay startState = new StartPlanningDay();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        while (!isPlannerFull(newPlanner)) {
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
                    //set wild animals for emergency appointments with strategy that calls WildAnimalFactory
                    Animal newGeneratedAnimal = strategyContextForEmergencyAppointmentAnimals.animalAccordingToStrategy(appointmentTime);
                    appointmentTime.setAnimal(newGeneratedAnimal);
                    Appointment newAppointment = newEmergencyAppointmentFactory.createAppointment(appointmentType, appointmentTime, veterinaryDoc, appointmentTime.getAnimal());
                    //Appointment urgency decorators
                    AppointmentUrgency appointmentUrgency = new AppointmentUrgency();
                    AppointmentUrgencyLevel urgentAppointment = new UrgentAppointmentUrgencyDecorator(appointmentUrgency);
                    urgentAppointment.addAppointmentUrgencyLevel();
                    bookedAppointmentList.add(newAppointment);
                    newPlanner.setAppointment(newAppointment);
                    newPlanner.setTimeSlot(appointmentTime);
                } else {
                    //set domestic animals for appointment with strategy that calls DomesticAnimalFactory
                    Animal newGeneratedAnimal = strategyContextForNormalAppointmentAnimals.animalAccordingToStrategy(appointmentTime);
                    appointmentTime.setAnimal(newGeneratedAnimal);
                    Appointment newAppointment = newNonEmergencyAppointmentFactory.createAppointment(appointmentType, appointmentTime, veterinaryDoc, appointmentTime.getAnimal());
                    //Appointment urgency decorators
                    AppointmentUrgency appointmentUrgency = new AppointmentUrgency();
                    AppointmentUrgencyLevel routineAppointment = new RoutineAppointmentUrgencyDecorator(appointmentUrgency);
                    routineAppointment.addAppointmentUrgencyLevel();
                    bookedAppointmentList.add(newAppointment);
                    newPlanner.setAppointment(newAppointment);
                }
            } else {
                System.out.println("Timeslot not available");
            }

            newPlanner.setAppointmentList(bookedAppointmentList);
        }

        StopPlanningDay stopPlanning = new StopPlanningDay();
        stopPlanning.doAction(context);
        System.out.println(context.getState().toString());

        bookedAppointmentList.stream()
                .sorted(Comparator.comparing(appointment -> {
                    TimeSlot timeslot = appointment.getAppointmentTimeSlot();
                    return timeslot.getSlotNumber();
                }))
                .forEach(appointment -> System.out.println(appointment.getAppointmentTimeSlot().getSlotName()
                        + "||" + appointment.getVeterinaryDoctor().getNameSurname()
                        + "||" + appointment.getAppointmentType()
                        + "||" + appointment.getAnimal().getAnimalSpecies()));
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
                        && timeSlot.getDoctorsName().equals(timeslotToCheck.getDoctorsName())
                        && timeSlot.getIsAvailable())
                .collect(Collectors.toList());
        return !availableTimeslots.isEmpty();
    }

    public boolean isPlannerFull(Planner planner) {
        return planner.getAppointmentList() != null && planner.getAppointmentList().size() >= 27;
    }

    protected List<VeterinaryDoctor> getAllDoctors() {
        return Arrays.asList(
                new VeterinaryDoctor("Peter Tooth"),
                new VeterinaryDoctor("Lauren Tail"),
                new VeterinaryDoctor("Oliver Tail"));
    }

    protected List<TimeSlot> getAllAppointmentTimeSlotList() {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        for (VeterinaryDoctor doctor : getAllDoctors()) {
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

    String getRandomAppointmentType() {
        AppointmentTypeEnum appointmentType = RandomEnumLogicClass.
                randomEnum(AppointmentTypeEnum.class);
        return appointmentType.name();
    }
}


