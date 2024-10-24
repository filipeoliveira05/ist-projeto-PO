package hva.satisfaction;

import hva.Hotel;
import hva.species.Species;
import hva.animal.Animal;
import hva.habitat.Habitat;
import hva.exceptions.UnknownAnimalException;

import java.util.Collection;

import java.io.Serial;
import java.io.Serializable;


public class AnimalSatisfactionStrategy implements SatisfactionStrategy, Serializable {
    
    private Hotel _hotel;

    public AnimalSatisfactionStrategy(Hotel hotel) {
        _hotel = hotel;
    }

    @Override
    public int calculateSatisfaction(String idAnimal) throws UnknownAnimalException {
        Animal animal = _hotel.getAnimal(idAnimal);
        if (animal == null) {
            throw new UnknownAnimalException(idAnimal);
        }

        String idHabitat = animal.getIdHabitat();
        Habitat habitat = _hotel.getHabitat(idHabitat);

        return Math.round(20 + 3 * countSameSpecies(animal, habitat) 
                - 2 * countDifferentSpecies(animal, habitat) 
                + (habitat.getArea() / habitat.getPopulation()) 
                + getHabitatInfluence(animal, habitat));
    }


    private int countSameSpecies(Animal animal, Habitat habitat) {
        int count = 0;
        Collection<Animal> animalsInHabitat = habitat.getAllAnimalsInHabitat();

        for (Animal otherAnimal : animalsInHabitat) {
            if (otherAnimal.getIdSpecies().equals(animal.getIdSpecies()) && otherAnimal != animal) {
                count++;
            }
        }
        
        return count;
    }

    private int countDifferentSpecies(Animal animal, Habitat habitat) {
        int count = 0;
        Collection<Animal> animalsInHabitat = habitat.getAllAnimalsInHabitat();

        for (Animal otherAnimal : animalsInHabitat) {
            if (!otherAnimal.getIdSpecies().equals(animal.getIdSpecies()) && !otherAnimal.equals(animal)) {
                count++;
            }
        }
        
        return count;
    }

    private int getHabitatInfluence(Animal animal, Habitat habitat) {
        String speciesId = animal.getIdSpecies();
        Species species = _hotel.getSpecies(speciesId);
    
        if (species != null) {
            return habitat.getSpeciesInfluence(species);
        }
        
        return 0;
    }
  
}