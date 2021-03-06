package models;


public class VeterinaryDoctor {

    private String nameSurname;

    public VeterinaryDoctor() {
    }

    public VeterinaryDoctor(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

}
