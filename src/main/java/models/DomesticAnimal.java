package models;

public class DomesticAnimal extends Animal {

    @Override
    public void setSpecies(String species) {
      this.species = species;
    }

    @Override
    public void isWildAnimal() {
        this.isWildAnimal = false;
    }
}
