package state;

public class PlannerStateContext {

    private PlannerState state;

    public PlannerStateContext() {
        state = null;
    }

    public PlannerState getState() {
        return state;
    }

    public void setState(PlannerState state) {
        this.state = state;
    }
}
