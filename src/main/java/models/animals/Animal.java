package models.animals;

abstract public class Animal {

    private boolean isWildAnimal;
    private String animal;

    public Animal(boolean isWildAnimal, String animal){
        this.isWildAnimal = isWildAnimal;
        this.animal = animal;
    }

    public boolean isWildAnimal() {
        return isWildAnimal;
    }

    public String getAnimalSpeciesName() {
        return animal;
    }
}
