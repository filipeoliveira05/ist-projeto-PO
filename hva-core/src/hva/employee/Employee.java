package hva.employee;

import hva.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.NoResponsibilityException;

import hva.habitat.Habitat;
import hva.species.Species;

import java.io.Serial;
import java.io.Serializable;


public class Employee implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081520L;

    private String id;
    private String name;
    
    
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public boolean isCaretaker() {
        return false;
    }


    public boolean isVet() {
        return false;
    }
}   