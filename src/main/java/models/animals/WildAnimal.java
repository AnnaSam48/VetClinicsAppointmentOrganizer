package models.animals;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WildAnimal extends Animal {

    private final boolean isWildAnimal;
    private final String animal;
    private SecureRandom wildAnimalRandom = new SecureRandom();
    List<String> wildAnimals =new ArrayList<>(Arrays.asList("Fox", "Badger", "Peregrine", "Lynx", "Rabbit", "Boar", "Bear", "Neighbourhood Hooligan"));

    public WildAnimal() {
        this.isWildAnimal = true;
        this.animal = getAnimalSpecies();

    }

    String getAnimalSpecies() {
        int randomAnimalIndex = wildAnimalRandom.nextInt(wildAnimals.size());
        return wildAnimals.get(randomAnimalIndex);
    }
}
