package models.animals;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomesticAnimal extends Animal {
    private boolean isWildAnimal;
    private String animal;
    private SecureRandom domesticAnimalRandom = new SecureRandom();
    List<String> domesticAnimals =new ArrayList<>(Arrays.asList("Cat", "Dog", "Parrot", "Hamster", "Horse", "Cow"));

    public DomesticAnimal() {
        this.isWildAnimal = false;
        this.animal = getAnimalSpecies();

    }

    String getAnimalSpecies() {
        int randomAnimalIndex = domesticAnimalRandom.nextInt(domesticAnimals.size());
        return domesticAnimals.get(randomAnimalIndex);
    }

}
