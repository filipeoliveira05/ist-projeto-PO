package hva.employee;

import hva.exceptions.DuplicateEmployeeKeyException;
import hva.habitat.Habitat;

import java.io.Serial;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CaretakerEmployee extends Employee{

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081524L;

    private final String type;
    private Map<String, Habitat> responsabilitiesHabitats;
    
    public CaretakerEmployee(String id, String name) {
        super(id, name);
        this.type = "TRT";
        this.responsabilitiesHabitats = new HashMap<>();
    }

    public void addHabitat(Habitat habitat){
        responsabilitiesHabitats.put(habitat.getId(), habitat);
    }

    public String getResponsabilitiesHabitatsAsString() {
        return String.join(", ", responsabilitiesHabitats.keySet());
    }
    
}