package hva.vaccine;

import hva.species.Species;
import hva.vaccine.Vaccination;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Vaccine implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410101444L;


    private String id;
    private String name;
    private int numberApplications;
    private Map<String, Species> speciess;
    private List<Vaccination> vaccinations;
    
    
    public Vaccine(String id, String name) {
        this.id = id;
        this.name = name;
        this.numberApplications = 0;
        this.speciess = new HashMap<>();
        this.vaccinations = new ArrayList<>();
    }


    public void addSpecies(Species species){
        speciess.put(species.getId(), species);
    }


    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public int getNumberApplications() {
        return this.vaccinations.size();
    }


    public String getSpeciesIdsAsString() {
        return String.join(",", speciess.keySet());
    }


    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }
}
