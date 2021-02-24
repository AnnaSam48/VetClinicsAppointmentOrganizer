package models;

public class TimeSlot {

    private int slotNumber;
    private String slotName;

    public TimeSlot() {
    }

    public TimeSlot(int slotNumber, String slotName) {
        this.slotNumber = slotNumber;
        this.slotName = slotName;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }
}
