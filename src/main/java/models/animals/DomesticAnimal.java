package models.animals;

import models.animals.Animal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DomesticAnimal extends Animal {
    private static final SecureRandom domesticAnimalRandom = new SecureRandom();
    List<String> domesticAnimals =new ArrayList<>(Arrays.asList("Cat", "Dog", "Parrot", "Hamster", "Horse", "Cow"));

    String getSpecies() {
        int randomAnimalIndex = domesticAnimalRandom.nextInt(domesticAnimals.size());
        return domesticAnimals.get(randomAnimalIndex);
    }
    @Override
    public String getAnimal() {
      return getSpecies();
    }

    @Override
    public void isWildAnimal() {
        this.isWildAnimal = false;
    }
}
