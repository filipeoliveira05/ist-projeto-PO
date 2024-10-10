package hva.animal;

import hva.exceptions.DuplicateAnimalKeyException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Animal implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410072133L;


    private String id;
    private String name;
    private String idSpecies;
    private String idHabitat;
    
    
    public Animal(String id, String name, String idSpecies, String idHabitat) {
        this.id = id;
        this.name = name;
        this.idSpecies = idSpecies;
        this.idHabitat = idHabitat;
        }



    //Getter for id
    public String getId() {
        return this.id;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Getter for species' id
    public String getIdSpecies() {
        return this.idSpecies;
    }

    
    //Getter for habitat's id
    public String getIdHabitat() {
        return this.idHabitat;
    }


}


