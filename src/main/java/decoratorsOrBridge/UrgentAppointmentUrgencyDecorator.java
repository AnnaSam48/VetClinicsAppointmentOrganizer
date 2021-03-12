package decoratorsOrBridge;

public class UrgentAppointmentUrgencyDecorator extends AppointmentUrgencyDecorator {

    public UrgentAppointmentUrgencyDecorator(AppointmentUrgency decoratedAppointment) {
        super(decoratedAppointment);
    }

    @Override
    public void addAppointmentUrgencyLevel() {
        decoratedAppointment.addAppointmentUrgencyLevel();
        setAppointmentAsUrgent(decoratedAppointment);
    }

    private void setAppointmentAsUrgent(AppointmentUrgencyLevel decoratedAppointment){
        System.out.println("This is emergency appointment.");
    }
}
