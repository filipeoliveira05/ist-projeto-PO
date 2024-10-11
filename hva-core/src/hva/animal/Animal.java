package hva.animal;

import hva.exceptions.DuplicateAnimalKeyException;

import java.io.Serial;
import java.io.Serializable;


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
    private String healthHistory;
    
    
    public Animal(String id, String name, String idSpecies, String idHabitat) {
        this.id = id;
        this.name = name;
        this.idSpecies = idSpecies;
        this.idHabitat = idHabitat;
        this.healthHistory = "VOID";
    }


    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public String getIdSpecies() {
        return this.idSpecies;
    }


    public String getIdHabitat() {
        return this.idHabitat;
    }

    public String getHealthHistory () {
        return this.healthHistory;
    }
}


