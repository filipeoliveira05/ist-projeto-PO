package hva.species;

import hva.animal.Animal;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Species implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410101445L;


    private String id;
    private String name;
    private Map<String, Animal> animals;
    
    
    public Species(String id, String name) {
        this.id = id;
        this.name = name;
        this.animals = new HashMap<>();
    }


    public void addAnimal(Animal animal) {
        animals.put(animal.getId(), animal);
    }


    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }
}
