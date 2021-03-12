package strategies;

import factories.animalFactories.AnimalFactory;
import factories.animalFactories.DomesticAnimalFactory;
import factories.animalFactories.WildAnimalFactory;
import models.TimeSlot;
import models.animals.Animal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonEmergencyAppointmentAnimalCreationStrategy implements AppointmentAnimalCreationStrategy {

    private SecureRandom domesticAnimalRandom = new SecureRandom();
    List<String> domesticAnimals =new ArrayList<>(Arrays.asList("Cat", "Dog", "Parrot", "Hamster", "Horse", "Cow"));

    @Override
    public Animal getNewAppointmentAnimal(TimeSlot appointmentTime) {

        AnimalFactory factory = new DomesticAnimalFactory();
        return factory.createAnimal(false, getAnimalSpecies());
    }

    String getAnimalSpecies() {
        int randomAnimalIndex = domesticAnimalRandom.nextInt(domesticAnimals.size());
        return domesticAnimals.get(randomAnimalIndex);
    }
}
