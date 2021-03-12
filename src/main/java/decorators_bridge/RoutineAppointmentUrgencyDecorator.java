package decorators_bridge;

public class RoutineAppointmentUrgencyDecorator extends AppointmentUrgencyDecorator {

    public RoutineAppointmentUrgencyDecorator(AppointmentUrgency decoratedAppointment) {
        super(decoratedAppointment);
    }
    @Override
    public void addAppointmentUrgencyLevel() {
        decoratedAppointment.addAppointmentUrgencyLevel();
        setAppointmentAsUrgent(decoratedAppointment);
    }

    private void setAppointmentAsUrgent(AppointmentUrgencyLevel decoratedAppointment){
        System.out.println("This is not urgent appointment.");
    }
}
