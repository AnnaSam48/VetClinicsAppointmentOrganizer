package state;

public class StartPlanningDay implements PlannerState {

    @Override
    public void doAction(PlannerStateContext context) {
        context.setState(this);
    }

    public String toString(){
        return "Booking appointments in planner.";
    }
}
