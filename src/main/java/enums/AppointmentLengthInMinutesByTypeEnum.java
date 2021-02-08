package enums;


public enum AppointmentLengthInMinutesByTypeEnum {

    CHECK_UP (45),
    TREATMENT (60),
    VACCINE(30),
    HOUSE_CALL(120),
    SURGERY(150);


    private int appointmentLengthInMinutes;

     AppointmentLengthInMinutesByTypeEnum(int appointmentLengthInMinutes) {
        this.appointmentLengthInMinutes = appointmentLengthInMinutes;
    }

    public int getAppointmentLengthInMinutes(){
         return appointmentLengthInMinutes;
    }
}
