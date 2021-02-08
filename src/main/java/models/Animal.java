package models;

abstract public class Animal {

    protected String species;
    protected boolean isWildAnimal;

    abstract String getSpecies();

    abstract boolean getIsWildAnimal();


}
