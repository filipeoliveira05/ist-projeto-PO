package hva.vaccine;

import hva.species.Species;
import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
    
    
    public Vaccine(String id, String name) {
        this.id = id;
        this.name = name;
        this.numberApplications = 0;
        this.speciess = new HashMap<>();
        }


    public void addSpecies(Species species){
        speciess.put(species.getId(), species);
    }

    //Getter for id
    public String getId() {
        return this.id;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Getter for numberApplications
    public int getNumberApplications() {
        return this.numberApplications;
    }

    public String getSpeciesIdsAsString() {
        return String.join(", ", speciess.keySet());
    }
    
}
