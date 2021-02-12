package models;

abstract public class Animal {

    protected String species;
    protected boolean isWildAnimal;

    abstract void setSpecies(String species);

    abstract void isWildAnimal();


}
