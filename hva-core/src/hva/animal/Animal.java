package hva.animal;

import hva.vaccine.Vaccination;

import hva.exceptions.DuplicateAnimalKeyException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

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
    private List<Vaccination> vaccinations;
    
    
    public Animal(String id, String name, String idSpecies, String idHabitat) {
        this.id = id;
        this.name = name;
        this.idSpecies = idSpecies;
        this.idHabitat = idHabitat;
        this.healthHistory = "VOID";
        this.vaccinations = new ArrayList<>();
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

    public void setHabitatId(String idHabitat) {
        this.idHabitat = idHabitat;
    }


    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }

    public List<Vaccination> getVaccinations() {
        return Collections.unmodifiableList(vaccinations);
    }


    public void addHealthEvent(int damage) {
        String event;
        if (damage == 0) {
            event = "NORMAL";
        } else if (damage >= 1 && damage <= 4) {
            event = "ACIDENTE";
        } else if (damage >= 5) {
            event = "ERRO";
        } else {
            event = "CONFUSÃO";
        }

        if (this.healthHistory.equals("VOID")) {
            this.healthHistory = event;
        } else {
            this.healthHistory += "," + event;
        }
    }
}