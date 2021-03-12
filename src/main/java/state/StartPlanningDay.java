package state;

public class StartPlanningDay implements PlannerState {
    @Override
    public void doAction(PlannerStateContext context) {
        System.out.println("Starting to book appointments for the day.");
        context.setState(this);
    }

    public String toString(){
        return "Booking appointment.";
    }
}
