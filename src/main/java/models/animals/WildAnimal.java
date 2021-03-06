package models.animals;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WildAnimal extends Animal {

    private static final SecureRandom wildAnimalRandom = new SecureRandom();
    List<String> wildAnimals =new ArrayList<>(Arrays.asList("Fox", "Badger", "Peregrine", "Lynx", "Rabbit", "Boar", "Bear", "Neighbourhood Hooligan"));
    String getSpecies() {

        int randomAnimalIndex = wildAnimalRandom.nextInt(wildAnimals.size());
        return wildAnimals.get(randomAnimalIndex);
    }
    @Override
    public String getAnimal() {
      return getSpecies();
    }

    @Override
    public void isWildAnimal() {
        this.isWildAnimal = true;
    }
}
