package hva.vaccine;

import hva.vaccine.Vaccine;
import hva.employee.VetEmployee;
import hva.animal.Animal;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Vaccination implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410212044L;


    private String idVaccine;
    private String idVet;
    private String idAnimal;
    private String idSpecies;
    
    
    public Vaccination(String idVaccine, String idVet, String idAnimal, String idSpecies) {
        this.idVaccine = idVaccine;
        this.idVet = idVet;
        this.idAnimal = idAnimal;
        this.idSpecies = idSpecies;
    }


    public String getIdVaccine() {
        return this.idVaccine;
    }


    public String getIdVet() {
        return this.idVet;
    }


    public String getIdAnimal() {
        return this.idAnimal;
    }

    public String getIdSpecies() {
        return this.idSpecies;
    }
}