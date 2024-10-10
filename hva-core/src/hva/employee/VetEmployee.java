package hva.employee;

import hva.exceptions.DuplicateEmployeeKeyException;
import hva.species.Species;

import java.io.Serial;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class VetEmployee extends Employee{

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081525L;

    private final String type;
    private Map<String, Species> responsabilitiesSpecies;
    
    public VetEmployee(String id, String name) {
        super(id, name);
        this.type = "VET";
        this.responsabilitiesSpecies = new HashMap<>();
    }

    public void addSpecies(Species species){
        responsabilitiesSpecies.put(species.getId(), species);
    }

    public String getResponsabilitiesSpeciesAsString() {
        return String.join(", ", responsabilitiesSpecies.keySet());
    }

    // Sobrescreve para retornar true
    @Override
    public boolean isVet() {
        return true;
    }

    // Sobrescreve para garantir que retorne false
    @Override
    public boolean isCaretaker() {
        return false;
    }
}