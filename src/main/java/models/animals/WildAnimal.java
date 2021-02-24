package models.animals;

import models.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WildAnimal extends Animal {

    List<String> wildAnimals =new ArrayList<>(Arrays.asList("Fox", "Badger", "Peregrine", "Lynx", "Rabbit"/*, "Boar", "Bear", "Neighbourhood Hooligan"*/));
    String getSpecies() {
        Random wildAnimalRandom = new Random();
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
