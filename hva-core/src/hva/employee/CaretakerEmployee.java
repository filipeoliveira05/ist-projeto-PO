package hva.employee;

import hva.exceptions.DuplicateEmployeeKeyException;
import hva.habitat.Habitat;

import java.io.Serial;
import java.util.Map;
import java.util.HashMap;


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


    @Override
    public boolean isCaretaker() {
        return true;
    }


    @Override
    public boolean isVet() {
        return false;
    } 
}