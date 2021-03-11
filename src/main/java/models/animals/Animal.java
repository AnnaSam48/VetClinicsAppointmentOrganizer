package models.animals;

abstract public class Animal {

    private boolean isWildAnimal;
    private String animal;

    public Animal(){}

    public boolean isWildAnimal() {
        return isWildAnimal;
    }

    public String getAnimalSpeciesName() {
        return animal;
    }
}
