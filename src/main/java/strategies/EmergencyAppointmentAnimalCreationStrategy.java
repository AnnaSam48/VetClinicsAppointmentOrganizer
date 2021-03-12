package strategies;

import factories.animalFactories.AnimalFactory;
import factories.animalFactories.WildAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmergencyAppointmentAnimalCreationStrategy implements AppointmentAnimalCreationStrategy {

    private SecureRandom wildAnimalRandom = new SecureRandom();
    List<String> wildAnimals =new ArrayList<>(Arrays.asList("Fox", "Badger", "Peregrine", "Lynx", "Rabbit", "Boar", "Bear", "Neighbourhood Hooligan"));

    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {
        AnimalFactory factory = new WildAnimalFactory();
        return factory.createAnimal(true, getAnimalSpecies());
    }

    String getAnimalSpecies() {
        int randomAnimalIndex = wildAnimalRandom.nextInt(wildAnimals.size());
        return wildAnimals.get(randomAnimalIndex);
    }
}
