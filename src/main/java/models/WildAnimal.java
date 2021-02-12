package models;

public class WildAnimal extends Animal{

    @Override
    public void setSpecies(String species) {
       this.species = species;
    }

    @Override
    public void isWildAnimal() {
        this.isWildAnimal = true;
    }
}
