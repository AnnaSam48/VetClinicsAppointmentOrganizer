package models.animals;

public abstract class Animal {

    private final boolean isWildAnimal;
    private final String animalSpecies;

    protected Animal(boolean isWildAnimal, String animalSpecies) {
        this.isWildAnimal = isWildAnimal;
        this.animalSpecies = animalSpecies;
    }

    public String getAnimalSpecies() {
        return animalSpecies;
    }

    public boolean isWild() {
        return isWildAnimal;
    }
}
