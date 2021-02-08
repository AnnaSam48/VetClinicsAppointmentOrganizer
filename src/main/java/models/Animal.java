package models;

public class Animal {

    private boolean wild = false;
    private String type;
    private String owner;

    public Animal() {
    }

    public Animal(boolean wild, String type, String owner) {
        this.wild = wild;
        this.type = type;
        this.owner = owner;
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

    public String getOwners() {
        return owner;
    }

    public void setOwners(String owner) {
        this.owner = owner;
    }
}
