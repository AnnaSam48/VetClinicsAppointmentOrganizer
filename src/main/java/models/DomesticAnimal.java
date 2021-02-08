package models;

import models.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DomesticAnimal extends Animal {

    List<String> domesticAnimals =new ArrayList<>(Arrays.asList("Cat", "Dog", "Parrot", "Hamster", "Horse", "Cow"));

    @Override
    String getSpecies() {
        Random wildAnimalRandom = new Random();
        int randomAnimalIndex = wildAnimalRandom.nextInt(domesticAnimals.size());
        return domesticAnimals.get(randomAnimalIndex);
    }

    @Override
    boolean getIsWildAnimal() {
        return false;
    }
}
