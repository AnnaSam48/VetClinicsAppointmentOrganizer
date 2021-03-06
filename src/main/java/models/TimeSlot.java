package models;

public class TimeSlot {

    private int slotNumber;
    private String slotName;
    private boolean isAvailable;
    private String doctorsName;

    public TimeSlot() {
    }

    public TimeSlot(int slotNumber, String slotName, boolean isAvailable) {
        this.slotNumber = slotNumber;
        this.slotName = slotName;
        this.isAvailable = isAvailable;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }
}
