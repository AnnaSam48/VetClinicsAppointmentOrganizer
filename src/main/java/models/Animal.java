package models;

public class Animal {

    private boolean wild = false;
    private String type;
    private String oener;

    public Animal() {
    }

    public Animal(boolean wild, String type, String oener) {
        this.wild = wild;
        this.type = type;
        this.oener = oener;
    }

    public boolean isWild() {
        return wild;
    }

    public void setWild(boolean wild) {
        this.wild = wild;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOener() {
        return oener;
    }

    public void setOener(String oener) {
        this.oener = oener;
    }
}
