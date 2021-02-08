package enums;


public enum AppointmentLengthInHoursByTypeEnum {

    CHECK_UP (45),
    TREATMENT (60),
    VACCINE(30),
    HOUSE_CALL(120),
    SURGERY(150);


    private int appointmentLengthInMinutes;

     AppointmentLengthInHoursByTypeEnum(int appointmentLengthInHours) {
        this.appointmentLengthInMinutes = appointmentLengthInHours;
    }

    public int getAppointmentLengthInHours(){
         return appointmentLengthInMinutes;
    }
}
