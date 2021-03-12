package state;

public class StopPlanningDay implements PlannerState{

    @Override
    public void doAction(PlannerStateContext context) {
        context.setState(this);
    }

    public String toString(){
        return "Booking of appointments stopped. Planner for the day is full";
    }
}
