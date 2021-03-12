package decorators_bridge;

public class AppointmentUrgencyDecorator implements AppointmentUrgencyLevel {

    protected AppointmentUrgency decoratedAppointment;

    public AppointmentUrgencyDecorator(AppointmentUrgency decoratedAppointment){
        this.decoratedAppointment = decoratedAppointment;
    };

    public void addAppointmentUrgencyLevel() {
        decoratedAppointment.addAppointmentUrgencyLevel();
    }
}
